package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.bool.AndExpression;
import edu.uva.softwarecons.model.expression.bool.NotExpression;
import edu.uva.softwarecons.model.expression.bool.OrExpression;
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
public class ValueTypeChecker extends FormBaseVisitor {

    public List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    public Map<String, Type> questionTypes;

    private String currentQuestionId;

    private Type expectedType;

    public ValueTypeChecker(Map<String, Type> questionTypes) {
        this.questionTypes = questionTypes;
    }

    public void validateType(String questionId, Expression expression, Type checkType){
        this.currentQuestionId = questionId;
        this.expectedType = checkType;
        expression.accept(this);
    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        expression.expression.accept(this);
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitAddExpression(AddExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        expression.expression.accept(this);
    }

    @Override
    public void visitIdExpression(IdExpression expression) {
        if(NumericType.class.equals(expectedType.getClass())){
            if(questionTypes.containsKey(expression.id) &&
                    !(questionTypes.get(expression.id) instanceof NumericType)){
                errors.add(new InvalidTypeError(currentQuestionId,
                        expectedType, questionTypes.get(expression.id)));
            }
        }else if(BooleanType.class.equals(expectedType.getClass())){
            if(questionTypes.containsKey(expression.id) &&
                    !(BooleanType.class.equals(questionTypes.get(expression.id).getClass()))){
                errors.add(new InvalidTypeError(currentQuestionId,
                        expectedType, questionTypes.get(expression.id)));
            }
        }
    }
}
