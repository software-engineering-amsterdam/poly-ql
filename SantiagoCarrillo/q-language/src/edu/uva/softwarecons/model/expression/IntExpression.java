package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class IntExpression implements Expression{

    int value;

    public IntExpression(int value) {
        this.value = value;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIntExpression(this);
    }
}
