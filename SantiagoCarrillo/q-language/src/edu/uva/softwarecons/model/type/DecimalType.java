package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.form.IFormElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/25/14
 */
public class DecimalType extends NumericType{

    private final float value;

    public DecimalType(float value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "decimal";
    }

    @Override
    public void accept(ITypeElementVisitor visitor) {
        visitor.visitDecimalType(this);
    }
}
