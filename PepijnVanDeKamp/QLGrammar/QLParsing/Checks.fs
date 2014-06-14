namespace QL
module Checks =
    open System   
    open System.Collections.Generic
    open QL.AbstractSyntaxTree
    open QL.Parsing
    open QL.Checking

    let joinMaps map1 map2 = Map.fold (fun acc key value -> Map.add key value acc) map1 map2
    let foldLists = List.fold (fun acc elem -> acc @ elem ) []
    let messageMapReduce statementFunction statements questioncollection messagelist = List.map (fun statement -> statementFunction statement questioncollection messagelist) statements |> foldLists
    let dependencyMapReduce dependencyFunction statements dependencyMap = List.map (fun statement -> dependencyFunction statement dependencyMap) statements |> List.reduce joinMaps

    let DuplicateLabelsCheck ast =
        let labelslist = new List<String>()
        let mapStatements checkFunction statements labelslist messagelist = List.map (fun statement -> checkFunction labelslist messagelist statement) statements |> foldLists
        let rec checkStatement (labelslist:List<String>) (messagelist:list<Message>) statement   =
            match statement with
            | Question(_,label,_,position)
            | ComputedQuestion(_,label,_,_,position)      -> let newmessagelist = if labelslist.Contains(label) then messagelist @ [(WarningMessage(String.Format("Duplicate Label '{0}'",label),position) :> Message)] else messagelist
                                                             labelslist.Add(label)
                                                             newmessagelist
            | IfThen(_,ifstatements,_)                    -> mapStatements checkStatement ifstatements labelslist messagelist
            | IfThenElse(_,ifstatements,elsestatements,_) -> mapStatements checkStatement (ifstatements @ elsestatements) labelslist messagelist
        mapStatements checkStatement ast.StatementList labelslist []

    let ReferenceUndefinedQuestionsCheck ast =
        let questionCollection = new List<String>()
        let checkReference (questioncollection:List<String>) id position = if not <| questioncollection.Contains(id) then [ErrorMessage(String.Format("Undefined question '{0}'",id),position) :> Message] else []
        let rec checkExpression expression (questioncollection:List<String>) (messagelist:list<Message>) position =
            match expression with
              | NegationExpression(negatedexpression)                  -> checkExpression negatedexpression questioncollection messagelist position
              | ArithmeticExpression(leftExpression,_,rightExpression) 
              | BinaryExpression(leftExpression,_,rightExpression)     -> checkExpression leftExpression questioncollection messagelist position @ checkExpression rightExpression questioncollection messagelist position
              | LiteralStatement(_)                                    -> messagelist
              | Id(identifier)                                         -> messagelist @ checkReference questioncollection identifier position
        let rec checkStatement statement (questioncollection:List<String>) (messagelist:list<Message>)  =
            match statement with
            | Question(id,_,_,position)                                   -> questioncollection.Add(id)
                                                                             messagelist
            | ComputedQuestion(id,_,_,expression,position)                -> let newmessagelist = checkExpression expression questioncollection messagelist position
                                                                             questioncollection.Add(id) 
                                                                             newmessagelist
            | IfThen(expression,ifstatements,position)                    -> checkExpression expression questioncollection messagelist position @ messageMapReduce checkStatement ifstatements questioncollection messagelist
            | IfThenElse(expression,ifstatements,elsestatements,position) -> checkExpression expression questioncollection messagelist position @ messageMapReduce checkStatement (ifstatements @ elsestatements) questioncollection messagelist
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let DuplicateQuestionDeclarationsMustBeOfSameTypeCheck ast =
        let questionCollection = new Dictionary<String,QuestionType>()
        let checkQuestionType id (questiontype:QuestionType) position  (messagelist:list<Message>) =
            if not <| questionCollection.ContainsKey(id) then 
                questionCollection.Add(id,questiontype) 
                messagelist
            else if not(questionCollection.[id] = questiontype) then 
                messagelist @ [(ErrorMessage(String.Format("Duplicate declaration of question '{0}' with different type ('{1}', but expected '{2}')",id,questiontype,questionCollection.[id]),position) :> Message)]
            else
                messagelist
        let rec checkStatement statement (questioncollection:Dictionary<String,QL.AbstractSyntaxTree.QuestionType>) (messagelist:list<Message>) = 
            match statement with
            | Question(id,_,questiontype,position)           -> checkQuestionType id questiontype position messagelist
            | ComputedQuestion(id,_,questiontype,_,position) -> checkQuestionType id questiontype position messagelist
            | IfThen(_,thenstatements,_)                     -> messageMapReduce checkStatement thenstatements questioncollection messagelist
            | IfThenElse(_,thenstatements,elsestatements,_)  -> messageMapReduce checkStatement (thenstatements @ elsestatements) questioncollection messagelist
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let ExpressionMustBeOfExpectedTypeCheck ast = 
        let questionCollection = new Dictionary<String,QuestionType>()
        let registerQuestion id questiontype (questioncollection:Dictionary<String,QuestionType>) = if not <| questioncollection.ContainsKey(id) then questioncollection.Add(id,questiontype)
        let checkIfQuestionIsOfType id questiontype (questioncollection:Dictionary<String,QuestionType>) (position:Position) = if questioncollection.ContainsKey(id) && not <| (questioncollection.[id] = questiontype) then [ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questioncollection.[id],questiontype),position) :> Message] else []
        let checkIfExpressionOfType lookuptype expectedtype (position:Position)  = if not(lookuptype = expectedtype) then [ErrorMessage(String.Format("Expression is of type '{0}', expected '{1}'", lookuptype, expectedtype),position) :> Message] else []
        let checkExpression expression expectedtype questioncollection position (messagelist:list<Message>) =
            match expression with
              | Id(identifier)                                  -> messagelist @ checkIfQuestionIsOfType identifier expectedtype questioncollection position
              | LiteralStatement(literal)                       -> messagelist @ checkIfExpressionOfType (mapLiteralToQLType literal) expectedtype position
              | NegationExpression(_) | BinaryExpression(_,_,_) -> messagelist @ checkIfExpressionOfType QL_Boolean expectedtype position
              | ArithmeticExpression(_,_,_)                     -> messagelist @ checkIfExpressionOfType QL_Integer expectedtype position
        let rec checkStatement statement questioncollection (messagelist:list<Message>) =
            let checkIfCondition condition statements position = checkExpression condition QL_Boolean questioncollection position messagelist @ messageMapReduce checkStatement statements questioncollection messagelist
            match statement with
            | Question(id,_,questiontype,_)                                -> registerQuestion id questiontype questioncollection
                                                                              messagelist
            | ComputedQuestion(id,_,questiontype,expression,position)      -> registerQuestion id questiontype questioncollection
                                                                              checkExpression expression questiontype questioncollection position messagelist
            | IfThen(condition,thenstatements,position)                    -> checkIfCondition condition thenstatements position
            | IfThenElse(condition,thenstatements,elsestatements,position) -> checkIfCondition condition (thenstatements @ elsestatements) position
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let OperandsMustBeOfValidTypeToOperatorsCheck ast = 
        let questionCollection = new Dictionary<String,InferedQuestionType>()
        let checkIfOfType (lookuptype:InferedQuestionType) (expectedtype:InferedQuestionType) (position:Position) = if not <| (lookuptype = expectedtype) then [ErrorMessage(String.Format("Operand is of type '{0}', expected '{1}'", lookuptype, expectedtype),position) :> Message] else []
        let checkIdentifierType id (questioncollection:Dictionary<String,InferedQuestionType>) = if not <| questioncollection.ContainsKey(id) then QL_Error else questioncollection.[id]
        let registerQuestion id (questiontype:InferedQuestionType) (questioncollection:Dictionary<String,InferedQuestionType>) = if not <| questioncollection.ContainsKey(id) then questioncollection.Add(id,questiontype)
        let checkIfQuestionIsOfType id questiontype (questioncollection:Dictionary<String,InferedQuestionType>) (position:Position) = if questioncollection.ContainsKey(id) && not <| (questioncollection.[id] = questiontype) then [ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questioncollection.[id],questiontype),position) :> Message] else []
        let inferedBoolean = QL_Boolean |> QL_Infered
        let inferedInteger = QL_Integer |> QL_Infered
        let expectedType  questioncollection expression = 
            match expression with
            | Id(identifier)                                  -> checkIdentifierType identifier questioncollection
            | LiteralStatement(literal)                       -> mapLiteralToQLType literal |> QL_Infered
            | NegationExpression(_) | BinaryExpression(_,_,_) -> inferedBoolean
            | ArithmeticExpression(_,_,_)                     -> inferedInteger
        let rec checkExpression expression (expectedtype:InferedQuestionType) questioncollection position (messagelist:list<Message>) =
            let checkExpressionFunction expression expectedType = checkExpression expression expectedType questioncollection position messagelist
            match expression with
            | Id(identifier)                                                            -> checkIfQuestionIsOfType identifier expectedtype questioncollection position
            | LiteralStatement(literal)                                                 -> checkIfOfType (mapLiteralToQLType literal |> QL_Infered) expectedtype position
            | BinaryExpression(leftexpression,BinaryOperator.Equals,rightexpression)
            | BinaryExpression(leftexpression,BinaryOperator.NotEquals,rightexpression) -> let inferedType = leftexpression |> expectedType questioncollection
                                                                                           checkExpressionFunction leftexpression inferedType @ checkExpressionFunction rightexpression inferedType
            | BinaryExpression(leftexpression,BinaryOperator.And,rightexpression)
            | BinaryExpression(leftexpression,BinaryOperator.Or,rightexpression)        -> checkExpressionFunction leftexpression inferedBoolean @ checkExpressionFunction rightexpression inferedBoolean
            | NegationExpression(negatedexpression)                                     -> checkExpressionFunction negatedexpression inferedBoolean
            | BinaryExpression(leftexpression,_,rightexpression)        
            | ArithmeticExpression(leftexpression,_,rightexpression)                    -> checkExpressionFunction leftexpression inferedInteger @ checkExpressionFunction rightexpression inferedInteger
        let rec checkStatement statement questioncollection (messagelist:list<Message>) = 
            let checkIfCondition condition statements position = checkExpression condition inferedBoolean questioncollection position messagelist @ messageMapReduce checkStatement statements questioncollection messagelist
            match statement with
            | Question(id,_,questiontype,_)                                -> registerQuestion id (questiontype |> QL_Infered) questioncollection
                                                                              messagelist
            | ComputedQuestion(id,_,questiontype,expression,position)      -> registerQuestion id (questiontype |> QL_Infered) questioncollection
                                                                              checkExpression expression (questiontype |> QL_Infered) questioncollection position messagelist
            | IfThen(condition,thenstatements,position)                    -> checkIfCondition condition thenstatements position
            | IfThenElse(condition,thenstatements,elsestatements,position) -> checkIfCondition condition (thenstatements @ elsestatements) position
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let CyclicDependencyCheck ast = 
        let lookupDependencies identifier (dependencymap:Map<string,Set<string>>) = if dependencymap.ContainsKey(identifier) then dependencymap.[identifier] else Set.empty
        let rec checkDependentIdentifiers thisIdentifier (identifierSet:Set<string>) (dependencySet:Set<string>) dependencyMap =
            [ for dependency in dependencySet do
                if identifierSet.Contains(dependency) && (dependency = thisIdentifier) then yield ErrorMessage(String.Format("Cyclic dependency '{0}'",thisIdentifier),Position()) :> Message
                else yield! checkDependentIdentifiers thisIdentifier (identifierSet.Add(dependency)) (lookupDependencies dependency dependencyMap) dependencyMap ] 
        let rec checkExpression dependentId expression (dependencyMap:Map<string,Set<string>>) =
            match expression with
            | Id(identifier)                                         ->  if not(dependencyMap.ContainsKey(dependentId)) then dependencyMap.Add(dependentId,Set.empty.Add(identifier)) else dependencyMap.Add(dependentId,dependencyMap.[dependentId].Add(identifier))                                                              
            | NegationExpression(negatedexpression)                  ->  dependencyMap |> checkExpression dependentId negatedexpression  
            | ArithmeticExpression(leftExpression,_,rightExpression)
            | BinaryExpression(leftExpression,_,rightExpression)     ->  dependencyMap |> checkExpression dependentId leftExpression |> checkExpression dependentId rightExpression
            | _                                                      ->  dependencyMap
        let rec checkStatement statement (dependencyMap:Map<string,Set<string>>) =
            match statement with
            | ComputedQuestion(id,_,_,expression,_)                   ->  dependencyMap |> checkExpression id expression
            | IfThen(expression,thenstatements,_)                     ->  dependencyMapReduce checkStatement thenstatements dependencyMap
            | IfThenElse(expression,thenstatements,elsestatements,_)  ->  dependencyMapReduce checkStatement (thenstatements @ elsestatements) dependencyMap
            | _ -> dependencyMap
        let dependencyMap = dependencyMapReduce checkStatement ast.StatementList Map.empty
        dependencyMap |> Map.toList |> List.map fst |> List.map (fun identifier -> checkDependentIdentifiers identifier (Set.empty.Add(identifier)) (lookupDependencies identifier dependencyMap) dependencyMap) |> foldLists         