package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.NumericType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.FormBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class ExpressionTypeChecker extends FormBaseVisitor {

    private List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    private Map<String, Type> questionTypes;

    private String currentQuestionId;

    private Class expectedType;

    public ExpressionTypeChecker(Map<String, Type> questionTypes) {
        this.questionTypes = questionTypes;
    }

    public void validateType(String questionId, Expression expression, Class checkType){
        this.currentQuestionId = questionId;
        this.expectedType = checkType;
        expression.accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitAddExpression(AddExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        validateBinaryExpressionTerm(expression.getLeftExpression());
        validateBinaryExpressionTerm(expression.getRightExpression());
    }

    private void validateBinaryExpressionTerm(Expression expression) {
        if(IdExpression.class.isInstance(expression)){
            validateIdExpressionType(((IdExpression) expression), NumericType.class, NumericType.class);
        }else
            expression.accept(this);
    }


    @Override
    public void visitIdExpression(IdExpression expression) {
        if(NumericType.class.equals(expectedType.getClass())){
            validateIdExpressionType(expression, NumericType.class, expectedType);

        }else if(BooleanType.class.equals(expectedType.getClass())){
            validateIdExpressionType(expression, BooleanType.class, expectedType);
        }
    }

    private void validateIdExpressionType(IdExpression expression, Class typeClass, Class expectedType) {
        if(questionTypes.containsKey(expression.getId()) &&
                !(typeClass.isInstance(questionTypes.get(expression.getId())))){
            errors.add(new InvalidTypeError(currentQuestionId, expression.getId(),
                    expectedType, questionTypes.get(expression.getId()).getClass()));
        }
    }

    public List<QuestionnaireError> getErrors() {
        return errors;
    }
}
