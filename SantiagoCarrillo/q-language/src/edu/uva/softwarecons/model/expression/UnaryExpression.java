package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class UnaryExpression implements Expression {

    private Expression expression;


    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }
}
