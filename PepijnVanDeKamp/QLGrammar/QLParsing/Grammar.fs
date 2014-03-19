namespace QL
module Grammar =


    type Position(State : Microsoft.FSharp.Text.Parsing.IParseState) =
        let startPos,endPos = State.ResultRange;
        member this.ColumnStart = startPos.Column
        member this.LineStart = startPos.Line
        member this.ColumnEnd = endPos.Column
        member this.LineEnd = endPos.Line
        override m.ToString() = sprintf "Line:%i Column:%i" startPos.Line startPos.Column
        

    type QuestionType = 
        | QL_Boolean 
        | QL_String 
        | QL_Money
        | QL_Integer


    type NumericOperator = 
         | Plus
         | Minus
         | Times
         | Divide

    type BinaryOperator =
         | Equals
         | NotEquals
         | GreaterThan
         | LessThan
         | GreaterEqualsThan
         | LessEqualsThan

    type Literal = 
         | Boolean of bool
         | Integer of int
         | String of string

    type Expression =
         | Id of string
         | Neg of Expression
         | ArithmicExpression of Expression * NumericOperator * Expression
         | BinaryExpression of Expression * BinaryOperator * Expression
         | LiteralStatement of Literal
        

        

    type Statement = 
    | Question of string * string * QuestionType * Position
    | ComputedQuestion of string * string * QuestionType * Expression
    | IfThen of Expression * Statement list
    | IfThenElse of Expression * Statement list * Statement list

//    type Statement = 
//        | QuestionStatement of Question
//        | ConditionStatement of Condition


    type Form =
        { Name : string;
          //QuestionList : Question list;
          StatementList : Statement list;
          //Conditions : Condition list;
         } 
         override m.ToString() = sprintf "%A" m

 

