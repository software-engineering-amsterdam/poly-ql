package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/25/14
 */
public class DecimalType extends Type{

    private float value;

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitDecimalType(this);
    }
}
