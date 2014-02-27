package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IdExpression implements Expression {

    public  String id;

    public IdExpression(String id) {
        this.id = id;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIdExpression(this);
    }
}
