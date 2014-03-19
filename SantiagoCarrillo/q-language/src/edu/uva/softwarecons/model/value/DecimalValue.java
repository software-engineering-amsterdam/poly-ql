package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class DecimalValue
    implements ArithmeticValue
{

    private final float value;

    public DecimalValue( float value )
    {
        this.value = value;
    }

    @Override
    public Float getValue()
    {
        return value;
    }

    @Override
    public boolean equals( Object obj )
    {
        return value == ( (DecimalValue) obj ).getValue();
    }

    @Override
    public Value add( Value value )
    {
        return new DecimalValue( this.value + ( (DecimalValue) value ).getValue() );
    }

    @Override
    public Value subtract( Value value )
    {
        return new DecimalValue( this.value - ( (DecimalValue) value ).getValue() );
    }

    @Override
    public Value divide( Value value )
    {
        return new DecimalValue( this.value / ( (DecimalValue) value ).getValue() );
    }

    @Override
    public Value multiply( Value value )
    {
        return new DecimalValue( this.value * ( (DecimalValue) value ).getValue() );
    }

    @Override
    public boolean greater( Value value )
    {
        return this.value > ( (DecimalValue) value ).getValue();
    }

    @Override
    public boolean greaterEqual( Value value )
    {
        return this.value >= ( (DecimalValue) value ).getValue();
    }

    @Override
    public boolean less( Value value )
    {
        return this.value < ( (DecimalValue) value ).getValue();
    }

    @Override
    public boolean lessEqual( Value value )
    {
        return this.value <= ( (DecimalValue) value ).getValue();
    }

    @Override
    public String toString()
    {
        return String.valueOf( value );
    }
}
