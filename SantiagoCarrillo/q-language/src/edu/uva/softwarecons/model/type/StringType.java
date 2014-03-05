package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class StringType extends Type{

    private final String value;

    public StringType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitStringType(this);
    }

    @Override
    public String toString() {
        return "string";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof StringType;
    }
}
