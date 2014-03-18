package ql.ast.expression.value;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class BooleanValue implements IValue
{
    public boolean value;

    public BooleanValue(boolean value)
    {
        this.value = value;
    }

    /**
     * Logical And (leftValue && rightValue)
     */
    public BooleanValue and(BooleanValue rightValue)
    {
        return new BooleanValue(this.value && rightValue.value);
    }

    /**
     * Logical Or (leftValue || rightValue)
     */
    public BooleanValue or(BooleanValue rightValue)
    {
        return new BooleanValue(this.value || rightValue.value);
    }

    /**
     * Not (! leftValue)
     * @return
     */
    public BooleanValue not()
    {
        return new BooleanValue(!this.value);
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof BooleanValue;
    }

    @Override
    public boolean equal(IValue value)
    {
        if (!this.equals(value)) {
            return false;
        }
        if (((BooleanValue) value).value != this.value) {
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
