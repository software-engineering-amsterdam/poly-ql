namespace QL
module TypeChecking =
 
    open System   
    open System.Collections.Generic
    open QL.Grammar
    open QL.Parsing

    type InferedQuestionType =
    | QL_Infered of QuestionType
    | QL_Error
    with override x.ToString() = match x with 
                                     | QL_Infered(questionType) -> questionType.ToString()
                                     | QL_Error -> "error"

    type WarningMessage(Message:string,Position:Position) =
        inherit Message(Message,Position)
        override this.ToString() = String.Format("WARNING: {0} - Line: {1} Column: {2}",Message,Position.LineStart,Position.ColumnStart)

    type ErrorMessage(Message:string,Position:Position) =
        inherit Message(Message,Position)
        override this.ToString() = String.Format("ERROR: {0} - Line: {1} Column: {2}",Message,Position.LineStart,Position.ColumnStart)

    type  ITypeRule =
        abstract member getMessages : QL.Grammar.Form -> seq<Message>

    let mapLiteralToQLType literalType =
        match literalType with
        | Boolean(_) -> QL_Boolean
        | Integer(_) -> QL_Integer
        | String(_)  -> QL_String



    type TypeChecker(Rules:List<ITypeRule>) = 
        member this.getMessages(formAst:QL.Grammar.Form) = seq{
                   for rule in Rules do
                       yield! rule.getMessages(formAst) }
            
