namespace QL
module Grammar =

    type QuestionType = 
        | QL_Boolean 
        | QL_String 
        | QL_Money
        | QL_Integer

    type Question =
        { QuestionId : string;
        QuestionString : string;
        QuestionType : QuestionType }

    type Condition =
        { Conditions : Condition list
          Questions: Question list
        }

    type Form =
        { Name : string;
          QuestionList : Question list;
          //Conditions : Condition list;
         } 
         override m.ToString() = sprintf "%A" m

    type NumericOperator = 
         | Add
         | Minus
         | Multiply
         | Divide

    type BinaryOperator =
         | Equals
         | NotEquals
         | GreatherThan
         | LessThen
         | GreaterEqualThan
         | GreatherLessThan

    type Literal = 
         | Boolean
         | Integer
         | Money

    type Expression =
        | ID
        | Neg of Expression
        | ArithmicExpression of Expression * NumericOperator * Expression
        | BinaryExpression of Expression * BinaryOperator * Expression
        | Literal
        

 

