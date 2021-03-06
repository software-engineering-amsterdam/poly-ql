﻿namespace QL
module Interpreter =
    open QL.AbstractSyntaxTree

    let rec evaluateExpression expression resolveIdValue =

        let evaluateBinaryExpression left operator right =
            match (left, operator, right) with
            | Boolean(leftValue), Equals,            Boolean(rightValue) -> Boolean(leftValue = rightValue)
            | Boolean(leftValue), NotEquals ,        Boolean(rightValue) -> Boolean(not <| leftValue = rightValue)
            | Boolean(leftValue), And,               Boolean(rightValue) -> Boolean(leftValue && rightValue)
            | Boolean(leftValue), Or ,               Boolean(rightValue) -> Boolean(leftValue || rightValue)
            | String(leftValue),  Equals,            String(rightValue)  -> Boolean(leftValue = rightValue)
            | String(leftValue),  NotEquals ,        String(rightValue)  -> Boolean(not <| (leftValue = rightValue))
            | Integer(leftValue), Equals,            Integer(rightValue) -> Boolean(leftValue = rightValue)
            | Integer(leftValue), NotEquals ,        Integer(rightValue) -> Boolean(not <| (leftValue = rightValue))
            | Integer(leftValue), GreaterEqualsThan, Integer(rightValue) -> Boolean(leftValue >= rightValue)
            | Integer(leftValue), GreaterThan ,      Integer(rightValue) -> Boolean(leftValue > rightValue)
            | Integer(leftValue), LessEqualsThan,    Integer(rightValue) -> Boolean(leftValue <= rightValue)
            | Integer(leftValue), LessThan ,         Integer(rightValue) -> Boolean(leftValue < rightValue)
            | _ -> failwith "Invalid combination of operands and operator in binary expression"
        
        let evaluateArithmeticExpression left operator right =
            match (left, operator, right) with
            | Integer(leftValue), Plus,   Integer(rightValue) -> Integer(leftValue + rightValue)
            | Integer(leftValue), Minus,  Integer(rightValue) -> Integer(leftValue - rightValue)
            | Integer(leftValue), Times,  Integer(rightValue) -> Integer(leftValue * rightValue)
            | Integer(leftValue), Divide, Integer(0)          -> Integer(0)
            | Integer(leftValue), Divide, Integer(rightValue) -> Integer(leftValue / rightValue)
            | _ -> failwith "Invalid combination of operands and operator in arithmetic expression"

        let evaluateNegationExpressionationExpression expressionvalue = 
            match expressionvalue with
            | Boolean(value)    -> Boolean(not <| value)
            | _                 -> failwith "Invalid combination of operands and operator in NegationExpressionation expression"

        match expression with
        | Id(id)                                        -> resolveIdValue(id)
        | LiteralStatement(value)                       -> value
        | NegationExpression(innerExpression)           -> evaluateNegationExpressionationExpression (evaluateExpression innerExpression resolveIdValue)
        | BinaryExpression(left,operator,right)         -> evaluateBinaryExpression (evaluateExpression left resolveIdValue) operator (evaluateExpression right resolveIdValue)
        | ArithmeticExpression(left,operator,right)     -> evaluateArithmeticExpression (evaluateExpression left resolveIdValue) operator (evaluateExpression right resolveIdValue)