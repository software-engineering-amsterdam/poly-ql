package edu.uva.softwarecons.model.value;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 3/13/14
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
        try
        {
            Date date = dateFormat.parse( value.getValue() );
            return date.compareTo( this.value ) > 0;
        }
        catch ( ParseException e )
        {
            //Date not comparable with invalid date
            return false;
        }
    }

    @Override
    public boolean greaterEqual( Value value )
    {
        try
        {
            Date date = dateFormat.parse( value.getValue() );
            return date.compareTo( this.value ) > 0 || date.compareTo( this.value ) == 0;
        }
        catch ( ParseException e )
        {
            //Date not comparable with invalid date
            return false;
        }
    }

    @Override
    public boolean less( Value value )
    {
        try
        {
            Date date = dateFormat.parse( value.getValue() );
            return date.compareTo( this.value ) < 0;
        }
        catch ( ParseException e )
        {
            //Date not comparable with invalid date
            return false;
        }
    }

    @Override
    public boolean lessEqual( Value value )
    {
        try
        {
            Date date = dateFormat.parse( value.getValue() );
            return date.compareTo( this.value ) < 0 || date.compareTo( this.value ) == 0;
        }
        catch ( ParseException e )
        {
            //Date not comparable with invalid date
            return false;
        }
    }

    @Override
    public String getValue()
    {
        return "\"" + ( null != value ? dateFormat.format( value ) : "" ) + "\"";
    }
}
