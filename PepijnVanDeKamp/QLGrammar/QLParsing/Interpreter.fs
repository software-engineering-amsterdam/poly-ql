namespace QL
module Interpreter =

    open QL.AbstractSyntaxTree
    open QL.Values

    let evaluateBinaryExpression left operator right =
        match (left, operator, right) with
        | QLBoolean(leftValue), Equals,            QLBoolean(rightValue) -> QLBoolean(leftValue = rightValue)
        | QLBoolean(leftValue), NotEquals ,        QLBoolean(rightValue) -> QLBoolean(not <| leftValue = rightValue)
        | QLString(leftValue),  Equals,            QLString(rightValue)  -> QLBoolean(leftValue = rightValue)
        | QLString(leftValue),  NotEquals ,        QLString(rightValue)  -> QLBoolean(not <| (leftValue = rightValue))
        | QLInteger(leftValue), Equals,            QLInteger(rightValue) -> QLBoolean(leftValue = rightValue)
        | QLInteger(leftValue), NotEquals ,        QLInteger(rightValue) -> QLBoolean(not <| (leftValue = rightValue))
        | QLInteger(leftValue), GreaterEqualsThan, QLInteger(rightValue) -> QLBoolean(leftValue >= rightValue)
        | QLInteger(leftValue), GreaterThan ,      QLInteger(rightValue) -> QLBoolean(not <| (leftValue > rightValue))
        | QLInteger(leftValue), LessEqualsThan,    QLInteger(rightValue) -> QLBoolean(leftValue <= rightValue)
        | QLInteger(leftValue), LessThan ,         QLInteger(rightValue) -> QLBoolean(not <| (leftValue < rightValue))
        | _ -> failwith "Invalid combination of operands and operator"
    
    let evaluateArithmeticExpression left operator right =
        match (left, operator, right) with
        | QLInteger(leftValue), Plus,   QLInteger(rightValue) -> QLInteger(leftValue + rightValue)
        | QLInteger(leftValue), Minus,  QLInteger(rightValue) -> QLInteger(leftValue - rightValue)
        | QLInteger(leftValue), Times,  QLInteger(rightValue) -> QLInteger(leftValue * rightValue)
        | QLInteger(leftValue), Divide, QLInteger(0)          -> QLInteger(0)
        | QLInteger(leftValue), Divide, QLInteger(rightValue) -> QLInteger(leftValue / rightValue)
        | _ -> failwith "Invalid combination of operands and operator"

    let evaluateNegationExpression expressionvalue = 
        match expressionvalue with
        | QLBoolean(value) -> QLBoolean(not <| value)
        | _ -> failwith "Invalid combination of operands and operator"