package ql.ast.expression_value;

import java.math.BigDecimal;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class IntegerValue extends NumberValue
{
    private final Integer _value;

    public IntegerValue(int value)
    {
        super(value);
        this._value = value;
    }

    @Override
    public Integer getValue()
    {
        return this._value;
    }

    @Override
    public IValue add(NumberValue rightValue)
    {
        return rightValue.addInteger(this);
    }

    @Override
    public IntegerValue addInteger(IntegerValue leftValue)
    {
        return new IntegerValue(leftValue.getValue() + this.getValue());
    }

    @Override
    public DecimalValue addDecimal(DecimalValue leftValue)
    {
        return leftValue.addDecimal(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue divide(NumberValue rightValue)
    {
        return rightValue.divideInteger(this);
    }

    @Override
    public IntegerValue divideInteger(IntegerValue leftValue)
    {
        return new IntegerValue(leftValue.getValue() / this.getValue());
    }

    @Override
    public IValue divideDecimal(DecimalValue leftValue)
    {
        return leftValue.divide(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue multiply(NumberValue rightValue)
    {
        return rightValue.multiplyInteger(this);
    }

    @Override
    public IntegerValue multiplyInteger(IntegerValue leftValue)
    {
        return new IntegerValue(leftValue.getValue() * this.getValue());
    }

    @Override
    public IValue multiplyDecimal(DecimalValue leftValue)
    {
        return leftValue.multiply(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue remainder(NumberValue rightValue)
    {
        return rightValue.remainderInteger(this);
    }

    @Override
    public IntegerValue remainderInteger(IntegerValue leftValue)
    {
        return new IntegerValue(leftValue.getValue() % this.getValue());
    }

    @Override
    public IValue remainderDecimal(DecimalValue leftValue)
    {
        return leftValue.remainder(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue subtract(NumberValue rightValue)
    {
        return rightValue.subtractInteger(this);
    }

    @Override
    public IntegerValue subtractInteger(IntegerValue leftValue)
    {
        return new IntegerValue(leftValue.getValue() - this.getValue());
    }

    @Override
    public IValue subtractDecimal(DecimalValue leftValue)
    {
        return leftValue.subtract(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue greaterThan(NumberValue rightValue)
    {
        return rightValue.greaterThanInteger(this);
    }

    @Override
    public BooleanValue greaterThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(leftValue.getValue() > this.getValue());
    }

    @Override
    public IValue greaterThanDecimal(DecimalValue leftValue)
    {
        return leftValue.greaterThan(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue greaterThanEqual(NumberValue rightValue)
    {
        return rightValue.greaterThanEqualInteger(this);
    }

    @Override
    public BooleanValue greaterThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(leftValue.getValue() >= this.getValue());
    }

    @Override
    public IValue greaterThanEqualDecimal(DecimalValue leftValue)
    {
        return leftValue.greaterThanEqual(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue lessThan(NumberValue rightValue)
    {
        return rightValue.lessThanInteger(this);
    }

    @Override
    public BooleanValue lessThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(leftValue.getValue() < this.getValue());
    }

    @Override
    public IValue lessThanDecimal(DecimalValue leftValue)
    {
        return leftValue.lessThan(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IValue lessThanEqual(NumberValue rightValue)
    {
        return rightValue.lesssThanEqualInteger(this);
    }

    @Override
    public BooleanValue lessThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(leftValue.getValue() <= this.getValue());
    }

    @Override
    public IValue lessThanEqualDecimal(DecimalValue leftValue)
    {
        return leftValue.lessThanEqual(new DecimalValue(new BigDecimal(this.getValue())));
    }

    @Override
    public IntegerValue unaryMinus()
    {
        return new IntegerValue(-this.getValue());
    }

    @Override
    public IntegerValue unaryPlus()
    {
        return new IntegerValue(+this.getValue());
    }

    @Override
    public boolean equals(IValue value)
    {
        return value instanceof IntegerValue;
    }

    @Override
    public <T> T accept(IValueElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
