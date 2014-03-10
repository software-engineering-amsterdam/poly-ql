package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class IntExpression implements Expression{

    private final int value;

    public IntExpression(int value) {
        this.value = value;
    }

    @Override
    public Type eval() {
        return null;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(IExpressionElementVisitor visitor) {
        visitor.visitIntExpression(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
