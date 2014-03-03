package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class BinaryExpression implements Expression {

    public Expression leftExpression;

    public Expression rightExpression;

    public Operator operator;


    protected BinaryExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public abstract Type eval();
}
