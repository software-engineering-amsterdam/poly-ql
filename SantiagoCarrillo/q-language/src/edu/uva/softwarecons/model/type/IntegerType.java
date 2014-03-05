package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

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
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIntegerType(this);
    }

    @Override
    public String toString() {
        return "integer";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IntegerType;
    }
}
