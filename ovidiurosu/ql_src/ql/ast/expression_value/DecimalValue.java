package ql.ast.expression_value;

import java.math.BigDecimal;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class DecimalValue extends NumberValue
{
    private final BigDecimal _value;

    public DecimalValue(BigDecimal value)
    {
        super(value);
        this._value = value;
    }

    @Override
    public BigDecimal getValue()
    {
        return this._value;
    }

    @Override
    public IValue add(NumberValue rightValue)
    {
        return rightValue.addDecimal(this);
    }

    @Override
    public DecimalValue addInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.getValue()).add(this.getValue()));
    }

    @Override
    public DecimalValue addDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.getValue().add(this.getValue()));
    }

    @Override
    public IValue divide(NumberValue rightValue)
    {
        return rightValue.divideDecimal(this);
    }

    @Override
    public DecimalValue divideInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.getValue()).divide(this.getValue()));
    }

    @Override
    public DecimalValue divideDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.getValue().divide(this.getValue()));
    }

    @Override
    public IValue multiply(NumberValue rightValue)
    {
        return rightValue.multiplyDecimal(this);
    }

    @Override
    public DecimalValue multiplyInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.getValue()).multiply(this.getValue()));
    }

    @Override
    public DecimalValue multiplyDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.getValue().multiply(this.getValue()));
    }

    @Override
    public IValue remainder(NumberValue rightValue)
    {
        return rightValue.remainderDecimal(this);
    }

    @Override
    public DecimalValue remainderInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.getValue()).remainder(this.getValue()));
    }

    @Override
    public DecimalValue remainderDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.getValue().remainder(this.getValue()));
    }

    @Override
    public IValue subtract(NumberValue rightValue)
    {
        return rightValue.subtractDecimal(this);
    }

    @Override
    public DecimalValue subtractInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.getValue()).subtract(this.getValue()));
    }

    @Override
    public DecimalValue subtractDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.getValue().subtract(this.getValue()));
    }

    @Override
    public IValue greaterThan(NumberValue rightValue)
    {
        return rightValue.greaterThanDecimal(this);
    }

    @Override
    public BooleanValue greaterThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.getValue()).compareTo(this.getValue()) > 0);
    }

    @Override
    public BooleanValue greaterThanDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.getValue().compareTo(this.getValue()) > 0);
    }

    @Override
    public IValue greaterThanEqual(NumberValue rightValue)
    {
        return rightValue.greaterThanEqualDecimal(this);
    }

    @Override
    public BooleanValue greaterThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.getValue()).compareTo(this.getValue()) >= 0);
    }

    @Override
    public BooleanValue greaterThanEqualDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.getValue().compareTo(this.getValue()) >= 0);
    }

    @Override
    public IValue lessThan(NumberValue rightValue)
    {
        return rightValue.lessThanDecimal(this);
    }

    @Override
    public BooleanValue lessThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.getValue()).compareTo(this.getValue()) < 0);
    }

    @Override
    public BooleanValue lessThanDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.getValue().compareTo(this.getValue()) < 0);
    }

    @Override
    public IValue lessThanEqual(NumberValue rightValue)
    {
        return rightValue.lessThanEqualDecimal(this);
    }

    @Override
    public BooleanValue lessThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.getValue()).compareTo(this.getValue()) <= 0);
    }

    @Override
    public BooleanValue lessThanEqualDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.getValue().compareTo(this.getValue()) <= 0);
    }

    @Override
    public DecimalValue unaryMinus()
    {
        return new DecimalValue(this.getValue().negate());
    }

    @Override
    public DecimalValue unaryPlus()
    {
        return new DecimalValue(this.getValue().plus());
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof DecimalValue;
    }

    @Override
    public <T> T accept(IValueElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
