package edu.uva.softwarecons.model.value;

import edu.uva.softwarecons.exception.InvalidOperationException;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public interface ArithmeticValue extends ComparableValue{

    public Value add(Value value);

    public Value subtract(Value value);

    public Value divide(Value value) throws InvalidOperationException;

    public Value multiply(Value value);

}
