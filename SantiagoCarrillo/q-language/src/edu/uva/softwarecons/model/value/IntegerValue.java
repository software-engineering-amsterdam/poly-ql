package edu.uva.softwarecons.model.value;

import edu.uva.softwarecons.exception.CompareException;
import edu.uva.softwarecons.exception.InvalidOperationException;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class IntegerValue implements ArithmeticValue{

    private final int value;

    public IntegerValue(int value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return value == Integer.parseInt(((IntegerValue)obj).getValue());
    }

    @Override
    public Value add(Value value) {
        return new IntegerValue(this.value + Integer.parseInt(value.getValue()));
    }

    @Override
    public Value subtract(Value value) {
        return new IntegerValue(this.value - Integer.parseInt(value.getValue()));
    }

    @Override
    public Value divide(Value value) throws InvalidOperationException {
        if(Integer.parseInt(value.getValue()) == 0)
            throw new InvalidOperationException("Invalid operation trying to divide by zero");
        return new IntegerValue(this.value / Integer.parseInt(value.getValue()));
    }

    @Override
    public Value multiply(Value value) {
        return new IntegerValue(this.value * Integer.parseInt(value.getValue()));
    }

    @Override
    public boolean greater(Value value) throws CompareException {
        return this.value > Integer.parseInt(value.getValue());
    }

    @Override
    public boolean greaterEqual(Value value) throws CompareException {
        return this.value >= Integer.parseInt(value.getValue());
    }

    @Override
    public boolean less(Value value) throws CompareException {
        return this.value < Integer.parseInt(value.getValue());
    }

    @Override
    public boolean lessEqual(Value value) throws CompareException {
        return this.value <= Integer.parseInt(value.getValue());
    }
}
