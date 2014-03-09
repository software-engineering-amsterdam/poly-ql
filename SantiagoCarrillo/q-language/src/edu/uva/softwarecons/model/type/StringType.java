package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.form.IFormElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

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
    public String toString() {
        return "string";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof StringType;
    }

    @Override
    public void accept(ITypeElementVisitor visitor) {
        visitor.visitStringType(this);
    }
}
