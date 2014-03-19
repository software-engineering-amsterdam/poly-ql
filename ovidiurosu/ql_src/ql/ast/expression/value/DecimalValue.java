package ql.ast.expression.value;

import java.math.BigDecimal;

import ql.ast.visitor_elements.IValueElementVisitor;

/**
 * @author orosu
 */
public class DecimalValue extends NumberValue
{
    public BigDecimal value;

    public DecimalValue(BigDecimal value)
    {
        super(value);
        this.value = value;
    }

    @Override
    public IValue add(NumberValue rightValue)
    {
        return rightValue.addDecimal(this);
    }

    @Override
    public DecimalValue addInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.value).add(this.value));
    }

    @Override
    public DecimalValue addDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.value.add(this.value));
    }

    @Override
    public IValue divide(NumberValue rightValue)
    {
        return rightValue.divideDecimal(this);
    }

    @Override
    public DecimalValue divideInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.value).divide(this.value));
    }

    @Override
    public IValue divideDecimal(DecimalValue leftValue)
    {
        IValue value;
        try {
            value = new DecimalValue(leftValue.value.divide(this.value));
        } catch (ArithmeticException exception) {
            value = new NullValue();
            //TODO ArithmeticException maybe show the error message in the GUI
            System.err.println("ArithmeticException! Decimal " + exception.getMessage());
        }
        return value;
    }

    @Override
    public IValue multiply(NumberValue rightValue)
    {
        return rightValue.multiplyDecimal(this);
    }

    @Override
    public DecimalValue multiplyInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.value).multiply(this.value));
    }

    @Override
    public DecimalValue multiplyDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.value.multiply(this.value));
    }

    @Override
    public IValue remainder(NumberValue rightValue)
    {
        return rightValue.remainderDecimal(this);
    }

    @Override
    public DecimalValue remainderInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.value).remainder(this.value));
    }

    @Override
    public DecimalValue remainderDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.value.remainder(this.value));
    }

    @Override
    public IValue subtract(NumberValue rightValue)
    {
        return rightValue.subtractDecimal(this);
    }

    @Override
    public DecimalValue subtractInteger(IntegerValue leftValue)
    {
        return new DecimalValue(new BigDecimal(leftValue.value).subtract(this.value));
    }

    @Override
    public DecimalValue subtractDecimal(DecimalValue leftValue)
    {
        return new DecimalValue(leftValue.value.subtract(this.value));
    }

    @Override
    public IValue greaterThan(NumberValue rightValue)
    {
        return rightValue.greaterThanDecimal(this);
    }

    @Override
    public BooleanValue greaterThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.value).compareTo(this.value) > 0);
    }

    @Override
    public BooleanValue greaterThanDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.value.compareTo(this.value) > 0);
    }

    @Override
    public IValue greaterThanEqual(NumberValue rightValue)
    {
        return rightValue.greaterThanEqualDecimal(this);
    }

    @Override
    public BooleanValue greaterThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.value).compareTo(this.value) >= 0);
    }

    @Override
    public BooleanValue greaterThanEqualDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.value.compareTo(this.value) >= 0);
    }

    @Override
    public IValue lessThan(NumberValue rightValue)
    {
        return rightValue.lessThanDecimal(this);
    }

    @Override
    public BooleanValue lessThanInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.value).compareTo(this.value) < 0);
    }

    @Override
    public BooleanValue lessThanDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.value.compareTo(this.value) < 0);
    }

    @Override
    public IValue lessThanEqual(NumberValue rightValue)
    {
        return rightValue.lessThanEqualDecimal(this);
    }

    @Override
    public BooleanValue lessThanEqualInteger(IntegerValue leftValue)
    {
        return new BooleanValue(new BigDecimal(leftValue.value).compareTo(this.value) <= 0);
    }

    @Override
    public BooleanValue lessThanEqualDecimal(DecimalValue leftValue)
    {
        return new BooleanValue(leftValue.value.compareTo(this.value) <= 0);
    }

    @Override
    public DecimalValue unaryMinus()
    {
        return new DecimalValue(this.value.negate());
    }

    @Override
    public DecimalValue unaryPlus()
    {
        return new DecimalValue(this.value.plus());
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
