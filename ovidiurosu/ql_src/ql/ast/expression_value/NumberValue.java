package ql.ast.expression_value;

/**
 * @author orosu
 */
public abstract class NumberValue implements IValue
{
    private final Number _value;

    public NumberValue(Number value)
    {
        this._value = value;
    }

    public abstract IValue add(NumberValue rightValue);
    public abstract IValue divide(NumberValue rightValue);
    public abstract IValue multiply(NumberValue rightValue);
    public abstract IValue remainder(NumberValue rightValue);
    public abstract IValue subtract(NumberValue rightValue);
    public abstract IValue greaterThan(NumberValue rightValue);
    public abstract IValue greaterThanEqual(NumberValue rightValue);
    public abstract IValue lessThan(NumberValue rightValue);
    public abstract IValue lessThanEqual(NumberValue rightValue);
    public abstract IValue unaryMinus();
    public abstract IValue unaryPlus();

    /*
     * ATTENTION!!! All operations are set to return NullValue
     * If you want something else, @Override method in child class
     */
    public IValue addInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue addDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue divideInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue divideDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue multiplyInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue multiplyDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue remainderInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue remainderDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue subtractInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue subtractDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue greaterThanInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue greaterThanDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue greaterThanEqualDecimal(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue greaterThanEqualInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue greaterThanEqualDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue lessThanInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue lessThanDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    public IValue lesssThanEqualInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue lessThanEqualInteger(IntegerValue leftValue)
    {
        return new NullValue();
    }

    public IValue lessThanEqualDecimal(DecimalValue leftValue)
    {
        return new NullValue();
    }

    @Override
    public Number getValue()
    {
        return this._value;
    }

    @Override
    public boolean equalsValue(IValue value)
    {
        if (!this.equals(value) ||
            ((NumberValue) value).getValue() != this.getValue())
        {
            return false;
        }
        return true;
    }
}
