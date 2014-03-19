package edu.uva.softwarecons.model.value;


/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public interface ArithmeticValue
    extends ComparableValue
{

    public Value add( Value value );

    public Value subtract( Value value );

    public Value divide( Value value );

    public Value multiply( Value value );

}
