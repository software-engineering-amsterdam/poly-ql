package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class BooleanType extends Type {

    private final boolean checked;

    public BooleanType(boolean checked) {
        this.checked = checked;
    }

    @Override
    public Boolean getValue() {
        return checked;
    }


    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitBooleanType(this);
    }

    @Override
    public String toString() {
        return "boolean";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BooleanType;
    }
}
