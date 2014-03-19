package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class BooleanValue
    implements Value
{

    private final boolean value;

    public BooleanValue( boolean value )
    {
        this.value = value;
    }


    @Override
    public Boolean getValue()
    {
        return value;
    }

    @Override
    public boolean equals( Object obj )
    {
        return ( (BooleanValue) obj ).value == this.value;
    }

    public BooleanValue and( Value value )
    {
        return new BooleanValue( this.value && ( (BooleanValue) value ).getValue() );
    }

    public BooleanValue or( Value value )
    {
        return new BooleanValue( this.value || ( (BooleanValue) value ).getValue() );
    }

    public BooleanValue not()
    {
        return new BooleanValue( !this.value );
    }

    @Override
    public String toString()
    {
        return String.valueOf( value );
    }


}
