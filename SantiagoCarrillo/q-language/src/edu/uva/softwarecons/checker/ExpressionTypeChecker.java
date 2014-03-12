package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */

//TODO Propagate types upward by returning the Type and check at operations Type.isInteger()

public class ExpressionTypeChecker implements IExpressionElementVisitor {

    private static final String ADD_OPERATOR = "+";
    private static final String SUBTRACT_OPERATOR = "-";
    private static final String MULTIPLICATION_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";
    private static final String GREATER_OPERATOR = ">";
    private static final String GREATER_EQUAL_OPERATOR = ">=";
    private static final String LESS_OPERATOR = "<";
    private static final String LESS_EQUAL_OPERATOR = "<=";
    private static final String EQUAL_OPERATOR = "==";
    private static final String NOT_EQUAL_OPERATOR = "!=";
    private static final String AND_OPERATOR = "&&";
    private static final String OR_OPERATOR = "||";
    private static final String NOT_OPERATOR = "!";

    private List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    private Map<String, Type> questionTypes;

    private String currentQuestionId;

    private Type expectedType;

    public ExpressionTypeChecker(Map<String, Type> questionTypes) {
        this.questionTypes = questionTypes;
    }

    public void validateType(String questionId, Expression expression, Type checkType){
        this.currentQuestionId = questionId;
        this.expectedType = checkType;
        expression.accept(this);
    }

    @Override
    public Type visitEqualExpression(EqualExpression expression) {
        validateBinaryExpressionTypeChildTypes(expression);
        return new BooleanType();
    }

    @Override
    public Type visitNotEqualExpression(NotEqualExpression expression) {
        validateBinaryExpressionTypeChildTypes(expression);
        return new BooleanType();
    }


    @Override
    public Type visitGreaterEqualExpression(GreaterEqualExpression expression) {
        checkInvalidTypeErrorForOperator(expression, new BooleanType(), GREATER_EQUAL_OPERATOR);
        validateBinaryExpressionTypeChildTypes(expression);
        return new BooleanType();
    }

    @Override
    public Type visitGreaterExpression(GreaterExpression expression) {
        checkInvalidTypeErrorForOperator(expression, new BooleanType(), GREATER_OPERATOR);
        validateBinaryExpressionTypeChildTypes(expression);
        return new BooleanType();
    }

    @Override
    public Type visitLessEqualExpression(LessEqualExpression expression) {
        checkInvalidTypeErrorForOperator(expression, new BooleanType(), LESS_OPERATOR);
        return  validateBinaryExpressionTypeChildTypes(expression);
    }

    @Override
    public Type visitLessExpression(LessExpression expression) {
        checkInvalidTypeErrorForOperator(expression, new BooleanType(), LESS_EQUAL_OPERATOR);
        return  validateBinaryExpressionTypeChildTypes(expression);
    }

    @Override
    public Type visitAndExpression(AndExpression expression) {
        return validateBinaryExpressionTypes(expression, new BooleanType(), AND_OPERATOR);
    }

    @Override
    public Type visitOrExpression(OrExpression expression) {
        return validateBinaryExpressionTypes(expression, new BooleanType(), OR_OPERATOR);
    }

    @Override
    public Type visitNotExpression(NotExpression expression) {
        return validateBinaryExpressionTerm(expression.getArgument(), new BooleanType(), NOT_OPERATOR);
    }


    @Override
    public Type visitAddExpression(AddExpression expression) {
        return validateNumericExpressionType(expression, ADD_OPERATOR);
    }

    @Override
    public Type visitMulExpression(MulExpression expression) {
        return validateNumericExpressionType(expression, MULTIPLICATION_OPERATOR);
    }

    @Override
    public Type visitDivExpression(DivExpression expression) {
        return validateNumericExpressionType(expression, DIVIDE_OPERATOR);
    }

    @Override
    public Type visitSubExpression(SubExpression expression) {
        return validateNumericExpressionType(expression, SUBTRACT_OPERATOR);
    }



    private Type validateBinaryExpressionTerm(Expression expression, Type expectedType, String operator) {
        Type expressionType = expression.accept(this);
        if(!expectedType.equals(expressionType))
            errors.add(new InvalidTypeError(operator, new BooleanType()));
        return expressionType;
    }


    @Override
    public Type visitIdExpression(IdExpression idExpression) {
        validateIdExpressionType(idExpression, expectedType);
        return questionTypes.get(idExpression.getId());
    }

    @Override
    public Type visitParenthesisExpression(ParenthesisExpression expression) {
        return expression.getArgument().accept(this);
    }

    private void validateIdExpressionType(IdExpression expression, Type expectedType) {
        if(!hasValidType(expression, expectedType)){
            errors.add(new InvalidTypeError(currentQuestionId, expression.getId(),
                    expectedType.toString(), questionTypes.get(expression.getId()).toString()));
        }
    }

    private boolean hasValidType(IdExpression expression, Type expectedType) {
        return questionTypes.containsKey(expression.getId()) &&
                expectedType.equals(questionTypes.get(expression.getId()));
    }

    private void checkInvalidTypeErrorForOperator(BinaryExpression expression, Type invalidType, String operator) {
        if(expression.getLeftExpression().equals(invalidType) ||
                expression.getRightExpression().equals(invalidType)){
            errors.add(new InvalidTypeError(operator, new BooleanType()));
        }
    }

    private Type validateBinaryExpressionTypeChildTypes(BinaryExpression expression) {
        Type leftExpressionType = expression.getLeftExpression().accept(this);
        Type rightExpressionType = expression.getRightExpression().accept(this);
        if(!leftExpressionType.equals(rightExpressionType))
            errors.add(new InvalidTypeError(currentQuestionId,
                    leftExpressionType.toString(), rightExpressionType.toString()));
        return leftExpressionType;
    }

    private Type validateBinaryExpressionTypes(BinaryExpression expression, Type expectedType, String operand) {
        Type leftExpressionType = expression.getLeftExpression().accept(this);
        Type rightExpressionType = expression.getRightExpression().accept(this);
        if(!leftExpressionType.equals(expectedType))
            errors.add(new InvalidTypeError(operand, leftExpressionType));
        if(!rightExpressionType.equals(expectedType))
            errors.add(new InvalidTypeError(operand, rightExpressionType));
        return leftExpressionType;
    }

    private Type validateNumericExpressionType(BinaryExpression expression, String operator) {
        checkInvalidTypeErrorForOperator(expression, new BooleanType(), operator);
        checkInvalidTypeErrorForOperator(expression, new DateType(), operator);
        return  validateBinaryExpressionTypeChildTypes(expression);
    }

    public List<QuestionnaireError> getErrors() {
        return errors;
    }
}
