package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class PrimitiveExpression implements Expression {

    Type type;

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitPrimitiveExpression(this);
    }
}
