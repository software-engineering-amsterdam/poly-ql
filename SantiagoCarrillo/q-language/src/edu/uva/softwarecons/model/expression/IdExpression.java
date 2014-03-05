package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

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
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIdExpression(this);
    }

    @Override
    public Type eval() {
        return null;
    }
}
