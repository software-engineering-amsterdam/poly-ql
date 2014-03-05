package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class UnaryExpression implements Expression {

    public Expression expression;

    public String id;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

}
