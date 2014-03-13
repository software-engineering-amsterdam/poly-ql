package edu.uva.softwarecons.model.value;

import edu.uva.softwarecons.exception.CompareException;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public interface ComparableValue extends Value{

    public boolean greater(Value value) throws CompareException;

    public boolean greaterEqual(Value value) throws CompareException;

    public boolean less(Value value) throws CompareException;

    public boolean lessEqual(Value value) throws CompareException;
}
