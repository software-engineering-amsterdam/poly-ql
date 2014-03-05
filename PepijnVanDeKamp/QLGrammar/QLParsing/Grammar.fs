namespace QL
module Grammar =

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
    | Question of string * string * QuestionType
    | Condition of Expression * Statement list

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

 

