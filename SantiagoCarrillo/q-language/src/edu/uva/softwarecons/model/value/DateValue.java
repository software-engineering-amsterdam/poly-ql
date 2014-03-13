package edu.uva.softwarecons.model.value;

import edu.uva.softwarecons.exception.InvalidDateFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class DateValue implements ComparableValue {

    private final Date value;

    public static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public DateValue(Date value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return ((DateValue)obj).getValue().equals(value.toString());
    }

    @Override
    public boolean greater(Value value) throws InvalidDateFormatException {
        try {
            Date date = dateFormat.parse(value.getValue());
            return date.compareTo(this.value) > 0;
        } catch (ParseException e) {
            throw new InvalidDateFormatException("The format for the date: '"+value.getValue()+"' is invalid");
        }
    }

    @Override
    public boolean greaterEqual(Value value) throws InvalidDateFormatException{
        try {
            Date date = dateFormat.parse(value.getValue());
            return date.compareTo(this.value) > 0 || date.compareTo(this.value) == 0;
        } catch (ParseException e) {
            throw new InvalidDateFormatException("The format for the date: '"+value.getValue()+"' is invalid");
        }
    }

    @Override
    public boolean less(Value value) throws InvalidDateFormatException{
        try {
            Date date = dateFormat.parse(value.getValue());
            return date.compareTo(this.value) < 0;
        } catch (ParseException e) {
            throw new InvalidDateFormatException("The format for the date: '"+value.getValue()+"' is invalid");
        }
    }

    @Override
    public boolean lessEqual(Value value) throws InvalidDateFormatException{
        try {
            Date date = dateFormat.parse(value.getValue());
            return date.compareTo(this.value) < 0 || date.compareTo(this.value) == 0;
        } catch (ParseException e) {
            throw new InvalidDateFormatException("The format for the date: '"+value.getValue()+"' is invalid");
        }
    }

    @Override
    public String getValue() {
        return dateFormat.format(value);
    }
}
