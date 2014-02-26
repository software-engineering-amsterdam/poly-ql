package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class ParenthesisExpression implements Expression{

    Expression expression;

    public ParenthesisExpression(Expression expression) {
        this.expression = expression;
    }
}
