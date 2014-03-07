package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.form.IFormElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class IntegerType extends NumericType{

    private final int value;

    public IntegerType(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "integer";
    }

    @Override
    public void accept(ITypeElementVisitor visitor) {
        visitor.visitIntegerType(this);
    }
}
