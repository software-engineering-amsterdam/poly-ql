package ql.ast.expression.value;

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
    public boolean equals(IValue value)
    {
        return value instanceof NullValue;
    }

    @Override
    public boolean equal(IValue value)
    {
        if (!this.equals(value)) {
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
