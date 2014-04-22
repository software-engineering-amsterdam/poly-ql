namespace QL
module Grammar =


    type Position(startPos : Lexing.Position, endPos : Lexing.Position) =
        member this.ColumnStart = startPos.Column
        member this.LineStart = startPos.Line
        member this.ColumnEnd = endPos.Column
        member this.LineEnd = endPos.Line
        new(state : Parsing.IParseState) = 
            let startPos, endPos = state.ResultRange
            Position(startPos, endPos)
        new() = Position(Lexing.Position.Empty, Lexing.Position.Empty)
        //override m.ToString() = sprintf "Line:%i Column:%i" startPos.Line startPos.Column
        override m.ToString() = "Position"
        

    type QuestionType = 
        | QL_Boolean 
        | QL_String 
        | QL_Integer
        with override x.ToString() = match x with 
                                     | QL_Boolean -> "boolean"
                                     | QL_String -> "string"
                                     | QL_Integer -> "integer"

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
         | ComputedQuestion of string * string * QuestionType * Expression * Position
         | IfThen of Expression * Statement list * Position
         | IfThenElse of Expression * Statement list * Statement list * Position

    type Form =
        { Name : string;
          StatementList : Statement list;
         } 
         override m.ToString() = sprintf "%+A" m




 

