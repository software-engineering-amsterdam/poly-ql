package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.form.IFormElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public abstract class NumericType extends Type{


    @Override
    public boolean equals(Object o) {
        return o instanceof NumericType;
    }


}
