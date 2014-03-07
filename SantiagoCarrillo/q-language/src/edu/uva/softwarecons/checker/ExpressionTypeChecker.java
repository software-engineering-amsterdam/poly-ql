package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.IntExpression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.FormBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class ExpressionTypeChecker implements IExpressionElementVisitor {

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
    public void visitEqualExpression(EqualExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitAddExpression(AddExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        validateBinaryExpressionNumericTerm(expression.getLeftExpression());
        validateBinaryExpressionNumericTerm(expression.getRightExpression());
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        validateBinaryExpressionBooleanTerm(expression.getLeftExpression());
        validateBinaryExpressionBooleanTerm(expression.getRightExpression());
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        validateBinaryExpressionBooleanTerm(expression.getLeftExpression());
        validateBinaryExpressionBooleanTerm(expression.getRightExpression());
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        validateBinaryExpressionBooleanTerm(expression.getArgument());
    }

    private void validateBinaryExpressionTerm(Expression expression, Type expectedType) {
        if(new IdExpression("").equals(expression)){
            validateIdExpressionType(((IdExpression) expression), expectedType);
        }else
            expression.accept(this);
    }

    private void validateBinaryExpressionNumericTerm(Expression expression) {
        validateBinaryExpressionTerm(expression, new IntegerType(0));
    }

    private void validateBinaryExpressionBooleanTerm(Expression expression) {
        validateBinaryExpressionTerm(expression, new BooleanType(false));
    }


    @Override
    public void visitIdExpression(IdExpression idExpression) {
        validateIdExpressionType(idExpression, expectedType);
    }

    @Override
    public void visitIntExpression(IntExpression expression) {

    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        expression.getArgument().accept(this);
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

    public List<QuestionnaireError> getErrors() {
        return errors;
    }
}
