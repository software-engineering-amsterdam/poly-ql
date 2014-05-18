namespace QL
module Checks =
 
    open System   
    open System.Collections.Generic
    open QL.AbstractSyntaxTree
    open QL.Parsing
    open QL.Checking

    type DependencyMap(ast) =
        let initializeDependencyMap =
            let rec checkExpression dependentId expression (dependencyMap:Map<string,Set<string>>) =
                match expression with
                | Id(identifier)                                                                ->  if not(dependencyMap.ContainsKey(dependentId)) then dependencyMap.Add(dependentId,Set.empty.Add(identifier)) else dependencyMap.Add(dependentId,dependencyMap.[dependentId].Add(identifier))                                                              
                | Neg(negatedexpression)                                                        ->  dependencyMap |> checkExpression dependentId negatedexpression  
                | ArithmeticExpression(leftExpression,_,rightExpression)
                | BinaryExpression(leftExpression,_,rightExpression)                            ->  dependencyMap |> checkExpression dependentId leftExpression |> checkExpression dependentId rightExpression
                | _                                                                             ->  dependencyMap
            let rec checkStatements statements (dependencyMap:Map<string,Set<string>>) =
                let mutable newdependencymap = dependencyMap
                for node in statements do
                    newdependencymap <- match node with
                                        | ComputedQuestion(id,_,_,expression,_)                 ->  newdependencymap |> checkExpression id expression
                                        | IfThen(expression,ifstatements,_)                     ->  newdependencymap |> checkStatements ifstatements
                                        | IfThenElse(expression,ifstatements,elsestatements,_)  ->  newdependencymap |> checkStatements ifstatements |> checkStatements elsestatements
                                        | _ -> newdependencymap
                newdependencymap
            Map.empty |> checkStatements ast.StatementList


        let lookupDependencies identifier (dependencymap:Map<string,Set<string>>) =
            if dependencymap.ContainsKey(identifier) then dependencymap.[identifier] else Set.empty

        member this.getDependentIdentifiers =
            initializeDependencyMap |> Map.toSeq |> Seq.map fst

        member this.getDependencies identifier =
            lookupDependencies identifier initializeDependencyMap


    let DuplicateLabelsCheck ast =
        let registerLabel (labelscollection:List<String>) (label:string) (position:Position) = 
            [ if labelscollection.Contains(label) then yield WarningMessage(String.Format("Duplicate Label '{0}'",label),position) :> Message else  labelscollection.Add(label) ]
        let rec checkStatements statements (labelscollection:List<String>) = 
            [ for node in statements do
                match node with
                | Question(_,label,_,position)
                | ComputedQuestion(_,label,_,_,position)      -> yield! registerLabel labelscollection label position
                | IfThen(_,ifstatements,_)                    -> yield! checkStatements ifstatements labelscollection
                | IfThenElse(_,ifstatements,elsestatements,_) -> yield! checkStatements ifstatements labelscollection
                                                                 yield! checkStatements elsestatements labelscollection ]
        checkStatements ast.StatementList (new List<String>())

    let ReferenceUndefinedQuestionsCheck ast =
        let checkReference (questioncollection:List<String>) id position = 
            [ if not <| questioncollection.Contains(id) then yield ErrorMessage(String.Format("Undefined question '{0}'",id),position) :> Message ]
        let rec checkExpression expression (questioncollection:List<String>) position =
            [ match expression with
              | Neg(negatedexpression)                                            -> yield! checkExpression negatedexpression questioncollection position
              | ArithmeticExpression(leftExpression,_,rightExpression)            -> yield! checkExpression leftExpression questioncollection position
                                                                                     yield! checkExpression rightExpression questioncollection position
              | BinaryExpression(leftExpression,_,rightExpression)                -> yield! checkExpression leftExpression questioncollection position
                                                                                     yield! checkExpression rightExpression questioncollection position
              | LiteralStatement(_)                                               -> yield! Seq.empty 
              | Id(identifier)                                                    -> yield! checkReference questioncollection identifier position]
        let rec checkStatements statements (questioncollection:List<String>) =
            [ for node in statements do
                match node with
                | Question(id,_,_,position)                                     -> questioncollection.Add(id)
                | ComputedQuestion(id,_,_,expression,position)                  -> yield! checkExpression expression questioncollection position
                                                                                   questioncollection.Add(id) 
                | IfThen(expression,ifstatements,position)                      -> yield! checkExpression expression questioncollection position
                                                                                   yield! checkStatements ifstatements questioncollection
                | IfThenElse(expression,ifstatements,elsestatements,position)   -> yield! checkExpression expression questioncollection position
                                                                                   yield! checkStatements ifstatements questioncollection
                                                                                   yield! checkStatements elsestatements questioncollection ]
        checkStatements ast.StatementList (new List<String>())

    let DuplicateQuestionDeclarationsMustBeOfSameTypeCheck ast =
        let checkQuestionType (questioncollection:Dictionary<String,QL.AbstractSyntaxTree.QuestionType>) id (questiontype:QuestionType) position =
            [ if not <| questioncollection.ContainsKey(id) then questioncollection.Add(id,questiontype)
            else if not(questioncollection.[id] = questiontype) then yield ErrorMessage(String.Format("Duplicate declaration of question '{0}' with different type ('{1}', but expected '{2}')",id,questiontype,questioncollection.[id]),position) :> Message ]
        let rec checkStatements statements (questioncollection:Dictionary<String,QL.AbstractSyntaxTree.QuestionType>) = 
            [ for node in statements do
                match node with
                | Question(id,_,questiontype,position)              -> yield! checkQuestionType questioncollection id questiontype position
                | ComputedQuestion(id,_,questiontype,_,position)    -> yield! checkQuestionType questioncollection id questiontype position
                | IfThen(_,ifstatements,_)                          -> yield! checkStatements ifstatements questioncollection
                | IfThenElse(_,ifstatements,elsestatements,_)       -> yield! checkStatements ifstatements questioncollection
                                                                       yield! checkStatements elsestatements questioncollection ]
        checkStatements ast.StatementList (new Dictionary<String,QuestionType>())

    let ExpressionMustBeOfExpectedTypeCheck ast = 
        let registerQuestion id questiontype (questioncollection:Dictionary<String,QuestionType>) =
            if not <| questioncollection.ContainsKey(id) then questioncollection.Add(id,questiontype)
        let checkIfQuestionIsOfType id questiontype (questioncollection:Dictionary<String,QuestionType>) (position:Position) =
            [ if questioncollection.ContainsKey(id) && not <| (questioncollection.[id] = questiontype) then yield ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questioncollection.[id],questiontype),position) :> Message ]
        let checkIfOfType lookuptype expectedtype (position:Position)  =
            [ if not(lookuptype = expectedtype) then yield ErrorMessage(String.Format("Expression is of type '{0}', expected '{1}'", lookuptype, expectedtype),position) :> Message ]
        let checkExpression expression expectedtype questioncollection position =
            [ match expression with
              | Id(identifier)                                                    -> yield! checkIfQuestionIsOfType identifier expectedtype questioncollection position
              | LiteralStatement(literal)                                         -> let literalType = mapLiteralToQLType literal
                                                                                     yield! checkIfOfType literalType expectedtype position
              | Neg(_)                                                                        
              | BinaryExpression(_,_,_)                                           -> yield! checkIfOfType QL_Boolean expectedtype position
              | ArithmeticExpression(_,_,_)                                       -> yield! checkIfOfType QL_Integer expectedtype position ]
        let rec checkStatements statements questioncollection =
            [ for node in statements do
                match node with
                | Question(id,_,questiontype,_)                                 -> registerQuestion id questiontype questioncollection
                | ComputedQuestion(id,_,questiontype,expression,position)       -> registerQuestion id questiontype questioncollection
                                                                                   yield! checkExpression expression questiontype questioncollection position
                | IfThen(condition,thenstatements,position)                     -> yield! checkExpression condition QL_Boolean questioncollection position
                | IfThenElse(condition,thenstatements,elsestatements,position)  -> yield! checkExpression condition QL_Boolean questioncollection position
                                                                                   yield! checkStatements thenstatements questioncollection
                                                                                   yield! checkStatements elsestatements questioncollection ]
        checkStatements ast.StatementList (new Dictionary<String,QuestionType>())

    let OperandsMustBeOfValidTypeToOperatorsCheck ast = 
        let checkIfOfType (lookuptype:InferedQuestionType) (expectedtype:InferedQuestionType) (position:Position) =
            [ if not <| (lookuptype = expectedtype) then yield ErrorMessage(String.Format("Operand is of type '{0}', expected '{1}'", lookuptype, expectedtype),position) :> Message ]
        let checkIdentifierType id (questioncollection:Dictionary<String,InferedQuestionType>) =
            if not <| questioncollection.ContainsKey(id) then QL_Error else questioncollection.[id]
        let registerQuestion id (questiontype:InferedQuestionType) (questioncollection:Dictionary<String,InferedQuestionType>) =
            if not <| questioncollection.ContainsKey(id) then questioncollection.Add(id,questiontype)
        let checkIfQuestionIsOfType id questiontype (questioncollection:Dictionary<String,InferedQuestionType>) (position:Position) =
            [ if questioncollection.ContainsKey(id) && not <| (questioncollection.[id] = questiontype) then yield ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questioncollection.[id],questiontype),position) :> Message ]
        let expectedType expression questioncollection = 
            match expression with
            | Id(identifier)                -> checkIdentifierType identifier questioncollection
            | LiteralStatement(literal)     -> mapLiteralToQLType literal |> QL_Infered
            | Neg(_)                        
            | BinaryExpression(_,_,_)       -> QL_Boolean |> QL_Infered
            | ArithmeticExpression(_,_,_)   -> QL_Integer |> QL_Infered
        let rec checkExpression expression (expectedtype:InferedQuestionType) questioncollection position =
            [ match expression with
              | Id(identifier)                                                            -> yield! checkIfQuestionIsOfType identifier expectedtype questioncollection position
              | LiteralStatement(literal)                                                 -> let literalType = mapLiteralToQLType literal |> QL_Infered
                                                                                             yield! checkIfOfType literalType expectedtype position
              | BinaryExpression(leftexpression,BinaryOperator.Equals,rightexpression)
              | BinaryExpression(leftexpression,BinaryOperator.NotEquals,rightexpression) -> let lefttype = expectedType leftexpression questioncollection
                                                                                             yield! checkExpression rightexpression lefttype questioncollection position        
              | Neg(negatedexpression)                                                    -> let expectedType = QL_Boolean |> QL_Infered
                                                                                             yield! checkExpression negatedexpression expectedType questioncollection position
              | BinaryExpression(leftexpression,_,rightexpression)        
              | ArithmeticExpression(leftexpression,_,rightexpression)                    -> let expectedType = QL_Integer |> QL_Infered
                                                                                             yield! checkExpression leftexpression expectedType questioncollection position
                                                                                             yield! checkExpression rightexpression expectedType questioncollection position ]
        let rec checkStatements statements questioncollection = 
            [ for node in statements do
                match node with
                | Question(id,_,questiontype,_)                                         -> let inferedType = questiontype |> QL_Infered 
                                                                                           registerQuestion id inferedType questioncollection
                | ComputedQuestion(id,_,questiontype,expression,position)               -> let inferedType = questiontype |> QL_Infered 
                                                                                           registerQuestion id inferedType questioncollection
                                                                                           yield! checkExpression expression inferedType questioncollection position
                | IfThen(condition,thenstatements,position)                             -> let inferedType = QL_Boolean |> QL_Infered
                                                                                           yield! checkExpression condition inferedType questioncollection position
                                                                                           yield! checkStatements thenstatements questioncollection
                | IfThenElse(condition,thenstatements,elsestatements,position)          -> let inferedType = QL_Boolean |> QL_Infered
                                                                                           yield! checkExpression condition inferedType questioncollection position
                                                                                           yield! checkStatements thenstatements questioncollection
                                                                                           yield! checkStatements elsestatements questioncollection ]
        checkStatements ast.StatementList (new Dictionary<String,InferedQuestionType>())

    let CyclicDependencyCheck ast = 
                    let dependencyMap = new DependencyMap(ast)
                    let rec checkDependentIdentifiers thisIdentifier (identifierSet:Set<string>) (dependencySet:Set<string>) =
                        [ for dependency in dependencySet do
                            if identifierSet.Contains(dependency) && (dependency = thisIdentifier) then
                                yield ErrorMessage(String.Format("Cyclic dependency '{0}'",thisIdentifier),Position()) :> Message
                            else
                                yield! checkDependentIdentifiers thisIdentifier (identifierSet.Add(dependency)) (dependencyMap.getDependencies dependency) ]      
                    [ for identifier in dependencyMap.getDependentIdentifiers do yield! checkDependentIdentifiers identifier (Set.empty.Add(identifier)) (dependencyMap.getDependencies identifier)]
                    