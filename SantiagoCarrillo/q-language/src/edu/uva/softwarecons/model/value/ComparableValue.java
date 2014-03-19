package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public interface ComparableValue
    extends Value
{

    public boolean greater( Value value );

    public boolean greaterEqual( Value value );

    public boolean less( Value value );

    public boolean lessEqual( Value value );
}
