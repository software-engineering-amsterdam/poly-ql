package edu.uva.softwarecons.evaluator;

import edu.uva.softwarecons.exception.CompareException;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.value.*;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

import java.util.HashMap;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class ExpressionEvaluator implements IExpressionEvalVisitor{


    private final HashMap<String, Value> context;

    public ExpressionEvaluator(HashMap<String, Value> context) {
        this.context = context;
    }

    @Override
    public Value visitAddExpression(AddExpression expression) throws CompareException {
        return ((ArithmeticValue)expression.getLeftExpression().accept(this)).
                add(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitDivExpression(DivExpression expression) throws CompareException {
        return ((ArithmeticValue)expression.getLeftExpression().accept(this)).
                divide(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitMulExpression(MulExpression expression) throws CompareException {
        return ((ArithmeticValue)expression.getLeftExpression().accept(this)).
                multiply(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitSubExpression(SubExpression expression) throws CompareException {
        return ((ArithmeticValue)expression.getLeftExpression().accept(this)).
                subtract(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitAndExpression(AndExpression expression) throws CompareException {
        return ((BooleanValue)expression.getLeftExpression().accept(this)).
                and(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitOrExpression(OrExpression expression) throws CompareException {
        return ((BooleanValue)expression.getLeftExpression().accept(this)).
                or(expression.getRightExpression().accept(this));
    }

    @Override
    public Value visitNotExpression(NotExpression expression) throws CompareException {
        return ((BooleanValue)expression.getArgument().accept(this)).not();
    }

    @Override
    public Value visitEqualExpression(EqualExpression expression) throws CompareException {
        return new BooleanValue(expression.getLeftExpression().accept(this).
                equals(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitNotEqualExpression(NotEqualExpression expression) throws CompareException {
        return new BooleanValue(!expression.getLeftExpression().accept(this).
                equals(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitGreaterEqualExpression(GreaterEqualExpression expression) throws CompareException {
        return new BooleanValue(((ComparableValue)expression.getLeftExpression().accept(this)).
                greaterEqual(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitGreaterExpression(GreaterExpression expression) throws CompareException {
        return new BooleanValue(((ComparableValue)expression.getLeftExpression().accept(this)).
                greater(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitLessEqualExpression(LessEqualExpression expression) throws CompareException {
        return new BooleanValue(((ComparableValue)expression.getLeftExpression().accept(this)).
                lessEqual(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitLessExpression(LessExpression expression) throws CompareException {
        return new BooleanValue(((ComparableValue)expression.getLeftExpression().accept(this)).
                less(expression.getRightExpression().accept(this)));
    }

    @Override
    public Value visitIdExpression(IdExpression expression) {
        return context.get(expression.getId());
    }

    @Override
    public Value visitBoolExpression(BoolExpression expression) {
        return new BooleanValue(expression.getValue());
    }

    @Override
    public Value visitIntExpression(IntExpression expression) {
        return new IntegerValue(expression.getValue());
    }
}
