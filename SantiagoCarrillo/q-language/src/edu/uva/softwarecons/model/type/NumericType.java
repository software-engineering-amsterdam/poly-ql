package edu.uva.softwarecons.model.type;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public abstract class NumericType
    implements Type
{

    /**
     * All classes that extend NumericType will be equal
     * in order to validate their Type on the typeChecker
     *
     * @param o NumericType instance
     * @return true if the Type is of NumericType
     */
    @Override
    public boolean equals( Object o )
    {
        return o instanceof NumericType;
    }


}
