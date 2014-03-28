package ql.ast.expression_value;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class BooleanValue implements IValue
{
    private final boolean _value;

    public BooleanValue(boolean value)
    {
        this._value = value;
    }

    public BooleanValue and(BooleanValue rightValue)
    {
        return new BooleanValue(this.getValue() && rightValue.getValue());
    }

    public BooleanValue or(BooleanValue rightValue)
    {
        return new BooleanValue(this.getValue() || rightValue.getValue());
    }

    public BooleanValue not()
    {
        return new BooleanValue(!this.getValue());
    }

    @Override
    public Boolean getValue()
    {
        return this._value;
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof BooleanValue;
    }

    @Override
    public boolean equalsValue(IValue value)
    {
        if (!this.equals(value) ||
            ((BooleanValue) value).getValue() != this.getValue())
        {
            return false;
        }
        return true;
    }

    @Override
    public <T> T accept(IValueElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
