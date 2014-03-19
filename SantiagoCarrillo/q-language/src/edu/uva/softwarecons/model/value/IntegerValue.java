package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class IntegerValue
    implements ArithmeticValue
{

    private final int value;

    public IntegerValue( int value )
    {
        this.value = value;
    }


    @Override
    public Integer getValue()
    {
        return value;
    }

    @Override
    public boolean equals( Object obj )
    {
        return value == ( (IntegerValue) obj ).getValue();
    }

    @Override
    public Value add( Value value )
    {
        return new IntegerValue( this.value + ( (IntegerValue) value ).getValue() );
    }

    @Override
    public Value subtract( Value value )
    {
        return new IntegerValue( this.value - ( (IntegerValue) value ).getValue() );
    }

    @Override
    public Value divide( Value value )
    {
        return new IntegerValue( this.value / ( (IntegerValue) value ).getValue() );
    }

    @Override
    public Value multiply( Value value )
    {
        return new IntegerValue( this.value * ( (IntegerValue) value ).getValue() );
    }

    @Override
    public boolean greater( Value value )
    {
        return this.value > ( (IntegerValue) value ).getValue();
    }

    @Override
    public boolean greaterEqual( Value value )
    {
        return this.value >= ( (IntegerValue) value ).getValue();
    }

    @Override
    public boolean less( Value value )
    {
        return this.value < ( (IntegerValue) value ).getValue();
    }

    @Override
    public boolean lessEqual( Value value )
    {
        return this.value <= ( (IntegerValue) value ).getValue();
    }

    @Override
    public String toString()
    {
        return String.valueOf( value );
    }
}
