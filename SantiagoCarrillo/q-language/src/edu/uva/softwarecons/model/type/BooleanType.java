package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class BooleanType extends Type {

    private boolean checked;


    @Override
    public Boolean getValue() {
        return checked;
    }


    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitBooleanType(this);
    }
}
