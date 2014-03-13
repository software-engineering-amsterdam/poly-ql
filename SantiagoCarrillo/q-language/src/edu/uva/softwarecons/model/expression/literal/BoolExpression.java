package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/12/14
 */
public class BoolExpression implements Expression {

    private boolean value;


    public BoolExpression(boolean value) {
        this.value = value;
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
       return new BooleanType();
    }

    @Override
    public Value accept(IExpressionEvalVisitor visitor) {
        return new BooleanValue(value);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoolExpression;
    }

    public boolean getValue() {
        return value;
    }


}
