package edu.uva.softwarecons.model.type;

import java.util.Date;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class DateType extends Type {

    private Date date;


    @Override
    public Date getValue() {
        return date;
    }

}