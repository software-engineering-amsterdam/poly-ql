package edu.uva.softwarecons.model.value;


import java.math.BigDecimal;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class CurrencyValue
    implements ArithmeticValue
{

    private final BigDecimal value;

    public CurrencyValue( BigDecimal value )
    {
        this.value = value;
    }


    @Override
    public BigDecimal getValue()
    {
        return value;
    }

    @Override
    public boolean equals( Object obj )
    {
        return ( (CurrencyValue) obj ).getValue().equals( value );
    }

    @Override
    public Value add( Value value )
    {

        return new CurrencyValue( this.value.add( ( (CurrencyValue) value ).getValue() ) );
    }

    @Override
    public Value subtract( Value value )
    {
        return new CurrencyValue( this.value.subtract( ( (CurrencyValue) value ).getValue() ) );
    }

    @Override
    public Value divide( Value value )
    {
        return new CurrencyValue( this.value.divide( ( (CurrencyValue) value ).getValue() ) );
    }

    @Override
    public Value multiply( Value value )
    {
        return new CurrencyValue( this.value.multiply( ( (CurrencyValue) value ).getValue() ) );
    }

    @Override
    public boolean greater( Value value )
    {
        return this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == 1;
    }

    @Override
    public boolean greaterEqual( Value value )
    {
        return this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == 1
            || this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == 0;
    }

    @Override
    public boolean less( Value value )
    {
        return this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == -1;
    }

    @Override
    public boolean lessEqual( Value value )
    {
        return this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == -1
            || this.value.compareTo( ( (CurrencyValue) value ).getValue() ) == 0;
    }

    @Override
    public String toString()
    {
        return String.valueOf( value );
    }


}
