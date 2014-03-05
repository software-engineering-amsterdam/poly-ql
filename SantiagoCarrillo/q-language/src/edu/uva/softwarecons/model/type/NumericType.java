package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class NumericType extends Type{


    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {

    }

    @Override
    public boolean equals(Object o) {
        return o instanceof NumericType;
    }
}
