package ql.ast.expression_value;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class StringValue implements IValue
{
    private final String _value;

    public StringValue(String value)
    {
        this._value = value;
    }

    @Override
    public String getValue()
    {
        return this._value;
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof StringValue;
    }

    @Override
    public boolean equalsValue(IValue value)
    {
        if (!this.equals(value) ||
            ((StringValue) value).getValue() != this.getValue())
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
