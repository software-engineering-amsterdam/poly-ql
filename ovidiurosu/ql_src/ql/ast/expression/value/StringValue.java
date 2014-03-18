package ql.ast.expression.value;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class StringValue implements IValue
{
    public String value;

    public StringValue(String value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof StringValue;
    }

    @Override
    public boolean equal(IValue value)
    {
        if (!this.equals(value)) {
            return false;
        }
        if (((StringValue) value).value != this.value) {
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
