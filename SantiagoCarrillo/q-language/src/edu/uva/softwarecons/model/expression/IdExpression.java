package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IdExpression implements Expression {

    private  final String id;

    public IdExpression(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(IExpressionElementVisitor visitor) {
        visitor.visitIdExpression(this);
    }

    @Override
    public Type eval() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IdExpression;
    }
}
