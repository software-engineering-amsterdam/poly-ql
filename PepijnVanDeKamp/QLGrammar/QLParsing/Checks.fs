namespace QL
module Checks =
    open System   
    open System.Collections.Generic
    open QL.AbstractSyntaxTree
    open QL.Parsing
    open QL.Checking

    let joinMaps map1 map2 = Map.fold (fun acc key value -> Map.add key value acc) map1 map2
    let foldLists = List.fold (fun acc elem -> acc @ elem ) []
    let messageMapReduce statementFunction statements questionCollection messageList = List.map (fun statement -> statementFunction statement questionCollection messageList) statements |> foldLists
    let dependencyMapReduce dependencyFunction statements dependencyMap = List.map (fun statement -> dependencyFunction statement dependencyMap) statements |> List.reduce joinMaps

    let duplicateLabelsCheck ast =
        let labelsList = new List<String>()
        let mapStatements checkFunction statements labelsList messageList = List.map (fun statement -> checkFunction labelsList messageList statement) statements |> foldLists
        let rec checkStatement (labelsList:List<String>) (messageList:list<Message>) statement   =
            match statement with
            | Question(_,label,_,position)
            | ComputedQuestion(_,label,_,_,position)      -> let newMessageList = if labelsList.Contains(label) then messageList @ [(WarningMessage(String.Format("Duplicate Label '{0}'",label),position) :> Message)] else messageList
                                                             labelsList.Add(label)
                                                             newMessageList
            | IfThen(_,thenStatements,_)                    -> mapStatements checkStatement thenStatements labelsList messageList
            | IfThenElse(_,thenStatements,elseStatements,_) -> mapStatements checkStatement (thenStatements @ elseStatements) labelsList messageList
        mapStatements checkStatement ast.StatementList labelsList []

    let referenceUndefinedQuestionsCheck ast =
        let questionCollection = new List<String>()
        let checkReference (questionCollection:List<String>) id position = if not <| questionCollection.Contains(id) then [ErrorMessage(String.Format("Undefined question '{0}'",id),position) :> Message] else []
        let rec checkExpression expression (questionCollection:List<String>) (messageList:list<Message>) position =
            match expression with
              | NegationExpression(negationExpression)                  -> checkExpression negationExpression questionCollection messageList position
              | ArithmeticExpression(leftExpression,_,rightExpression) 
              | BinaryExpression(leftExpression,_,rightExpression)     -> checkExpression leftExpression questionCollection messageList position @ checkExpression rightExpression questionCollection messageList position
              | LiteralStatement(_)                                    -> messageList
              | Id(identifier)                                         -> messageList @ checkReference questionCollection identifier position
        let rec checkStatement statement (questionCollection:List<String>) (messageList:list<Message>)  =
            match statement with
            | Question(id,_,_,position)                                   -> questionCollection.Add(id)
                                                                             messageList
            | ComputedQuestion(id,_,_,expression,position)                -> let newmessageList = checkExpression expression questionCollection messageList position
                                                                             questionCollection.Add(id) 
                                                                             newmessageList
            | IfThen(expression,thenStatements,position)                    -> checkExpression expression questionCollection messageList position @ messageMapReduce checkStatement thenStatements questionCollection messageList
            | IfThenElse(expression,thenStatements,elseStatements,position) -> checkExpression expression questionCollection messageList position @ messageMapReduce checkStatement (thenStatements @ elseStatements) questionCollection messageList
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let duplicateQuestionDeclarationsMustBeOfSameTypeCheck ast =
        let questionCollection = new Dictionary<String,QuestionType>()
        let checkQuestionType id (questionType:QuestionType) position  (messageList:list<Message>) =
            if not <| questionCollection.ContainsKey(id) then 
                questionCollection.Add(id,questionType) 
                messageList
            else if not(questionCollection.[id] = questionType) then 
                messageList @ [(ErrorMessage(String.Format("Duplicate declaration of question '{0}' with different type ('{1}', but expected '{2}')",id,questionType,questionCollection.[id]),position) :> Message)]
            else
                messageList
        let rec checkStatement statement (questionCollection:Dictionary<String,QL.AbstractSyntaxTree.QuestionType>) (messageList:list<Message>) = 
            match statement with
            | Question(id,_,questionType,position)           -> checkQuestionType id questionType position messageList
            | ComputedQuestion(id,_,questionType,_,position) -> checkQuestionType id questionType position messageList
            | IfThen(_,thenStatements,_)                     -> messageMapReduce checkStatement thenStatements questionCollection messageList
            | IfThenElse(_,thenStatements,elseStatements,_)  -> messageMapReduce checkStatement (thenStatements @ elseStatements) questionCollection messageList
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let expressionMustBeOfExpectedTypeCheck ast = 
        let questionCollection = new Dictionary<String,QuestionType>()
        let registerQuestion id questionType (questionCollection:Dictionary<String,QuestionType>) = if not <| questionCollection.ContainsKey(id) then questionCollection.Add(id,questionType)
        let checkIfQuestionIsOfType id questionType (questionCollection:Dictionary<String,QuestionType>) (position:Position) = if questionCollection.ContainsKey(id) && not <| (questionCollection.[id] = questionType) then [ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questionCollection.[id],questionType),position) :> Message] else []
        let checkIfExpressionOfType lookupType expectedType (position:Position)  = if not(lookupType = expectedType) then [ErrorMessage(String.Format("Expression is of type '{0}', expected '{1}'", lookupType, expectedType),position) :> Message] else []
        let checkExpression expression expectedType questionCollection position (messageList:list<Message>) =
            match expression with
              | Id(identifier)                                  -> messageList @ checkIfQuestionIsOfType identifier expectedType questionCollection position
              | LiteralStatement(literal)                       -> messageList @ checkIfExpressionOfType (mapLiteralToQLType literal) expectedType position
              | NegationExpression(_) | BinaryExpression(_,_,_) -> messageList @ checkIfExpressionOfType QL_Boolean expectedType position
              | ArithmeticExpression(_,_,_)                     -> messageList @ checkIfExpressionOfType QL_Integer expectedType position
        let rec checkStatement statement questionCollection (messageList:list<Message>) =
            let checkIfCondition condition statements position = checkExpression condition QL_Boolean questionCollection position messageList @ messageMapReduce checkStatement statements questionCollection messageList
            match statement with
            | Question(id,_,questionType,_)                                -> registerQuestion id questionType questionCollection
                                                                              messageList
            | ComputedQuestion(id,_,questionType,expression,position)      -> registerQuestion id questionType questionCollection
                                                                              checkExpression expression questionType questionCollection position messageList
            | IfThen(condition,thenStatements,position)                    -> checkIfCondition condition thenStatements position
            | IfThenElse(condition,thenStatements,elseStatements,position) -> checkIfCondition condition (thenStatements @ elseStatements) position
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let operandsMustBeOfValidTypeToOperatorsCheck ast = 
        let questionCollection = new Dictionary<String,InferedQuestionType>()
        let checkIfOfType (lookupType:InferedQuestionType) (expectedType:InferedQuestionType) (position:Position) = if not <| (lookupType = expectedType) then [ErrorMessage(String.Format("Operand is of type '{0}', expected '{1}'", lookupType, expectedType),position) :> Message] else []
        let checkIdentifierType id (questionCollection:Dictionary<String,InferedQuestionType>) = if not <| questionCollection.ContainsKey(id) then QL_Error else questionCollection.[id]
        let registerQuestion id (questionType:InferedQuestionType) (questionCollection:Dictionary<String,InferedQuestionType>) = if not <| questionCollection.ContainsKey(id) then questionCollection.Add(id,questionType)
        let checkIfQuestionIsOfType id questionType (questionCollection:Dictionary<String,InferedQuestionType>) (position:Position) = if questionCollection.ContainsKey(id) && not <| (questionCollection.[id] = questionType) then [ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questionCollection.[id],questionType),position) :> Message] else []
        let inferedBoolean = QL_Boolean |> QL_Infered
        let inferedInteger = QL_Integer |> QL_Infered
        let inferExpectedType  questionCollection expression = 
            match expression with
            | Id(identifier)                                  -> checkIdentifierType identifier questionCollection
            | LiteralStatement(literal)                       -> mapLiteralToQLType literal |> QL_Infered
            | NegationExpression(_) | BinaryExpression(_,_,_) -> inferedBoolean
            | ArithmeticExpression(_,_,_)                     -> inferedInteger
        let rec checkExpression expression (expectedType:InferedQuestionType) questionCollection position (messageList:list<Message>) =
            let checkExpressionFunction expression expectedType = checkExpression expression expectedType questionCollection position messageList
            match expression with
            | Id(identifier)                                                            -> checkIfQuestionIsOfType identifier expectedType questionCollection position
            | LiteralStatement(literal)                                                 -> checkIfOfType (mapLiteralToQLType literal |> QL_Infered) expectedType position
            | BinaryExpression(leftExpression,BinaryOperator.Equals,rightExpression)
            | BinaryExpression(leftExpression,BinaryOperator.NotEquals,rightExpression) -> let inferedType = leftExpression |> inferExpectedType questionCollection
                                                                                           checkExpressionFunction leftExpression inferedType @ checkExpressionFunction rightExpression inferedType
            | BinaryExpression(leftExpression,BinaryOperator.And,rightExpression)
            | BinaryExpression(leftExpression,BinaryOperator.Or,rightExpression)        -> checkExpressionFunction leftExpression inferedBoolean @ checkExpressionFunction rightExpression inferedBoolean
            | NegationExpression(negationExpression)                                    -> checkExpressionFunction negationExpression inferedBoolean
            | BinaryExpression(leftExpression,_,rightExpression)        
            | ArithmeticExpression(leftExpression,_,rightExpression)                    -> checkExpressionFunction leftExpression inferedInteger @ checkExpressionFunction rightExpression inferedInteger
        let rec checkStatement statement questionCollection (messageList:list<Message>) = 
            let checkIfCondition condition statements position = checkExpression condition inferedBoolean questionCollection position messageList @ messageMapReduce checkStatement statements questionCollection messageList
            match statement with
            | Question(id,_,questionType,_)                                -> registerQuestion id (questionType |> QL_Infered) questionCollection
                                                                              messageList
            | ComputedQuestion(id,_,questionType,expression,position)      -> registerQuestion id (questionType |> QL_Infered) questionCollection
                                                                              checkExpression expression (questionType |> QL_Infered) questionCollection position messageList
            | IfThen(condition,thenStatements,position)                    -> checkIfCondition condition thenStatements position
            | IfThenElse(condition,thenStatements,elseStatements,position) -> checkIfCondition condition (thenStatements @ elseStatements) position
        messageMapReduce checkStatement ast.StatementList questionCollection []

    let cyclicDependencyCheck ast = 
        let lookupDependencies identifier (dependencyMap:Map<string,Set<string>>) = if dependencyMap.ContainsKey(identifier) then dependencyMap.[identifier] else Set.empty
        let rec checkDependentIdentifiers thisIdentifier (identifierSet:Set<string>) (dependencySet:Set<string>) dependencyMap =
            [ for dependency in dependencySet do
                if identifierSet.Contains(dependency) && (dependency = thisIdentifier) then yield ErrorMessage(String.Format("Cyclic dependency '{0}'",thisIdentifier),Position()) :> Message
                else yield! checkDependentIdentifiers thisIdentifier (identifierSet.Add(dependency)) (lookupDependencies dependency dependencyMap) dependencyMap ] 
        let rec checkExpression dependentId expression (dependencyMap:Map<string,Set<string>>) =
            match expression with
            | Id(identifier)                                         ->  if not(dependencyMap.ContainsKey(dependentId)) then dependencyMap.Add(dependentId,Set.empty.Add(identifier)) else dependencyMap.Add(dependentId,dependencyMap.[dependentId].Add(identifier))                                                              
            | NegationExpression(negationExpression)                  ->  dependencyMap |> checkExpression dependentId negationExpression  
            | ArithmeticExpression(leftExpression,_,rightExpression)
            | BinaryExpression(leftExpression,_,rightExpression)     ->  dependencyMap |> checkExpression dependentId leftExpression |> checkExpression dependentId rightExpression
            | _                                                      ->  dependencyMap
        let rec checkStatement statement (dependencyMap:Map<string,Set<string>>) =
            match statement with
            | ComputedQuestion(id,_,_,expression,_)                   ->  dependencyMap |> checkExpression id expression
            | IfThen(expression,thenStatements,_)                     ->  dependencyMapReduce checkStatement thenStatements dependencyMap
            | IfThenElse(expression,thenStatements,elseStatements,_)  ->  dependencyMapReduce checkStatement (thenStatements @ elseStatements) dependencyMap
            | _ -> dependencyMap
        let dependencyMap = dependencyMapReduce checkStatement ast.StatementList Map.empty
        dependencyMap |> Map.toList |> List.map fst |> List.map (fun identifier -> checkDependentIdentifiers identifier (Set.empty.Add(identifier)) (lookupDependencies identifier dependencyMap) dependencyMap) |> foldLists         