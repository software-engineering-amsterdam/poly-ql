package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.util.Date;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class DateType extends Type {

    private final Date date;

    public DateType(Date date) {
        this.date = date;
    }

    @Override
    public Date getValue() {
        return date;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitDateType(this);
    }

    @Override
    public String toString() {
        return "date";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DateType;
    }
}