namespace QL
module TypeChecker =
 
    open System   
    open System.Collections.Generic
    open QL.Grammar

    [<AbstractClass>] 
    type TypeCheckMessage(Message:string,Position:Position) =
         member this.Message with get() = Message
         member this.Position with get() = Position
         

    type WarningMessage(Message:string,Position:Position) =
        inherit TypeCheckMessage(Message,Position)
        override this.ToString() = String.Format("WARNING: {0} - Line: {1} Column: {2}",Message,Position.LineStart,Position.ColumnStart)

    type ErrorMessage(Message:string,Position:Position) =
        inherit TypeCheckMessage(Message,Position)
        override this.ToString() = String.Format("ERROR: {0} - Line: {1} Column: {2}",Message,Position.LineStart,Position.ColumnStart)

    type  ITypeRule =
        abstract member getMessages : QL.Grammar.Form -> seq<TypeCheckMessage>

    let mapLiteralToQLType LiteralType =
        match LiteralType with
        | Boolean(_) -> QL_Boolean
        | Integer(_) -> QL_Integer
        | String(_)  -> QL_String

    type DuplicateLabelsRule() =
        interface ITypeRule with
            member this.getMessages ast =
                let labels = new List<String>()
                let registerLabel (labelscollection:List<String>) (label:string) (position:Position) = seq{
                    if labels.Contains(label) then
                        yield WarningMessage(String.Format("Duplicate Label '{0}'",label),position) :> TypeCheckMessage
                    else 
                        labels.Add(label);
                       } 
                let rec checkStatements statements (labelscollection:List<String>) = seq{ 
                    for node in statements do
                        match node with
                        | Question(_,label,_,position)                -> yield! registerLabel labelscollection label position
                        | ComputedQuestion(_,label,_,_,position)      -> yield! registerLabel labelscollection label position
                        | IfThen(_,ifstatements,_)                    -> yield! checkStatements ifstatements labelscollection
                        | IfThenElse(_,ifstatements,elsestatements,_) -> yield! checkStatements ifstatements labelscollection
                                                                         yield! checkStatements elsestatements labelscollection
                }
                checkStatements ast.StatementList labels

    type ReferenceUndefinedQuestionsRule() =
        interface ITypeRule with
            member this.getMessages ast =
                let definedQuestions = new List<String>()
                let checkReference (questioncollection:List<String>) (id:String) (position:Position) = seq{
                    if not <| questioncollection.Contains(id) then
                        yield ErrorMessage(String.Format("Undefined question '{0}'",id),position) :> TypeCheckMessage                                       
                }
                let rec checkExpression expression (questioncollection:List<String>) (position:Position) = seq{
                    match expression with
                    | Id(identifier)                                            -> yield! checkReference questioncollection identifier position
                    | Neg(negatedexpression)                                    -> yield! checkExpression negatedexpression questioncollection position
                    | ArithmicExpression(leftExpression,_,rightExpression)      -> yield! checkExpression leftExpression questioncollection position
                                                                                   yield! checkExpression rightExpression questioncollection position
                    | BinaryExpression(leftExpression,_,rightExpression)        -> yield! checkExpression leftExpression questioncollection position
                                                                                   yield! checkExpression rightExpression questioncollection position
                    | LiteralStatement(_)                                       -> yield! Seq.empty
                }
                let rec checkStatements statements (questioncollection:List<String>) = seq{ 
                    for node in statements do
                        match node with
                        | Question(id,_,_,position)                                     -> questioncollection.Add(id)
                        | ComputedQuestion(id,_,_,expression,position)                  -> yield! checkExpression expression questioncollection position
                                                                                           questioncollection.Add(id) 
                        | IfThen(expression,ifstatements,position)                      -> yield! checkExpression expression questioncollection position
                                                                                           yield! checkStatements ifstatements questioncollection
                        | IfThenElse(expression,ifstatements,elsestatements,position)   -> yield! checkExpression expression questioncollection position
                                                                                           yield! checkStatements ifstatements questioncollection
                                                                                           yield! checkStatements elsestatements questioncollection
                }
                checkStatements ast.StatementList definedQuestions

    type DuplicateQuestionDeclarationsMustBeOfSameTypeRule() =
        interface ITypeRule with
                member this.getMessages ast =
                    let questiontypes = new Dictionary<String,QL.Grammar.QuestionType>();
                    let checkQuestionType (questioncollection:Dictionary<String,QL.Grammar.QuestionType>) (id:String) (questiontype:QuestionType) (position:Position) = seq{
                        if not <| questioncollection.ContainsKey(id) then
                            questioncollection.Add(id,questiontype)
                        else if not(questioncollection.[id] = questiontype) then
                            yield ErrorMessage(String.Format("Duplicate declaration of question '{0}' with different type ('{1}', but expected '{2}')",id,questiontype,questioncollection.[id]),position) :> TypeCheckMessage                                       
                    }
                    let rec checkStatements statements (questioncollection:Dictionary<String,QL.Grammar.QuestionType>) = seq{ 
                        for node in statements do
                            match node with
                            | Question(id,_,questiontype,position)                -> yield! checkQuestionType questioncollection id questiontype position
                            | ComputedQuestion(id,_,questiontype,_,position)      -> yield! checkQuestionType questioncollection id questiontype position
                            | IfThen(_,ifstatements,_)                    -> yield! checkStatements ifstatements questioncollection
                            | IfThenElse(_,ifstatements,elsestatements,_) -> yield! checkStatements ifstatements questioncollection
                                                                             yield! checkStatements elsestatements questioncollection
                    }
                    checkStatements ast.StatementList questiontypes

    type ExpressionMustBeOfExpectedTypeRule() = 
        interface ITypeRule with
                member this.getMessages ast =
                    let questiontypes = new Dictionary<String,QL.Grammar.QuestionType>();
                    let registerQuestion id questiontype (questioncollection:Dictionary<String,QL.Grammar.QuestionType>) =
                        if not <| questioncollection.ContainsKey(id) then
                            questioncollection.Add(id,questiontype)
                    let checkIfQuestionIsOfType id questiontype (questioncollection:Dictionary<String,QL.Grammar.QuestionType>) (position:Position) = seq{
                        if not(questioncollection.ContainsKey(id) && questioncollection.[id] = questiontype) then
                            yield ErrorMessage(String.Format("Identifier '{0}' is of type '{1}', expected '{2}'",id,questioncollection.[id],questiontype),position) :> TypeCheckMessage
                        }
                    let checkIfOfType lookuptype expectedtype (position:Position)  = seq{
                        if not(lookuptype = expectedtype) then
                            yield ErrorMessage(String.Format("Expression is of type '{0}', expected '{1}'", lookuptype, expectedtype),position) :> TypeCheckMessage
                        }
                    let checkExpression expression expectedtype questioncollection position = seq{
                        match expression with
                        | Id(identifier)                                            -> yield! checkIfQuestionIsOfType identifier expectedtype questioncollection position
                        | Neg(negatedexpression)                                    -> yield! checkIfOfType QL_Boolean expectedtype position
                        | ArithmicExpression(leftExpression,_,rightExpression)      -> yield! checkIfOfType QL_Integer expectedtype position
                        | BinaryExpression(leftExpression,_,rightExpression)        -> yield! checkIfOfType QL_Boolean expectedtype position
                        | LiteralStatement(literal)                                 -> let literalType = mapLiteralToQLType literal
                                                                                       yield! checkIfOfType literalType expectedtype position

                    }
                    let rec checkStatements statements questioncollection = seq{ 
                        for node in statements do
                            match node with
                            | Question(id,_,questiontype,_)                          -> registerQuestion id questiontype questioncollection
                            | ComputedQuestion(id,_,questiontype,expression,position)       -> registerQuestion id questiontype questioncollection
                                                                                               yield! checkExpression expression questiontype questioncollection position
                            | IfThen(expression,thenstatements,position)                    -> yield! checkExpression expression QL_Boolean questioncollection position
                            | IfThenElse(expression,thenstatements,elsestatements,position) -> yield! checkExpression expression QL_Boolean questioncollection position
                                                                                               yield! checkStatements thenstatements questioncollection
                                                                                               yield! checkStatements elsestatements questioncollection
                    }
                    checkStatements ast.StatementList questiontypes




    type TypeChecker(Rules:List<ITypeRule>) = 
        member this.getMessages(formAst:QL.Grammar.Form) = seq{
                   for rule in Rules do
                       yield! rule.getMessages(formAst) }
            
