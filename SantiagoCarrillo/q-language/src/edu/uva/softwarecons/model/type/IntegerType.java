package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class IntegerType extends NumericType{


    @Override
    public String toString() {
        return "integer";
    }

    @Override
    public void accept(ITypeElementVisitor visitor) {
        visitor.visitIntegerType(this);
    }
}
