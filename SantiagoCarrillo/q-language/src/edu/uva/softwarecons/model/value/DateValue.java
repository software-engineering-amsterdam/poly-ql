package edu.uva.softwarecons.model.value;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class DateValue
    implements ComparableValue
{

    private final Date value;

    public static final DateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" );

    public DateValue( Date value )
    {
        this.value = value;
    }

    @Override
    public boolean equals( Object obj )
    {
        return ( (DateValue) obj ).getValue().equals( value.toString() );
    }

    @Override
    public boolean greater( Value value )
    {
        Date date = ( (DateValue) value ).getValue();
        return date.compareTo( this.value ) > 0;
    }

    @Override
    public boolean greaterEqual( Value value )
    {
        Date date = ( (DateValue) value ).getValue();
        return date.compareTo( this.value ) > 0 || date.compareTo( this.value ) == 0;
    }

    @Override
    public boolean less( Value value )
    {
        Date date = ( (DateValue) value ).getValue();
        return date.compareTo( this.value ) < 0;
    }

    @Override
    public boolean lessEqual( Value value )
    {
        Date date = ( (DateValue) value ).getValue();
        return date.compareTo( this.value ) < 0 || date.compareTo( this.value ) == 0;
    }

    @Override
    public Date getValue()
    {
        return value;
    }


    @Override
    public String toString()
    {
        return null != value ? ( "\"" + dateFormat.format( value ) + "\"" ) : null;
    }
}
