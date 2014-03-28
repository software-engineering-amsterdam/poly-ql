package ql.ast.expression_value;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class NullValue implements IValue
{
    public NullValue()
    {
    }

    @Override
    public Void getValue()
    {
        return null;
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof NullValue;
    }

    @Override
    public boolean equalsValue(IValue value)
    {
        return this.equals(value);
    }

    @Override
    public <T> T accept(IValueElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
