package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/20/14
 */
public class DateType
    implements Type
{

    @Override
    public String toString()
    {
        return "date";
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof DateType;
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitDateType( this );
    }
}