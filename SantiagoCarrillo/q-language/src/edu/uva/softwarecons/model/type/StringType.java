package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class StringType
    implements Type
{


    public StringType()
    {
    }

    @Override
    public String toString()
    {
        return "string";
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof StringType;
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitStringType( this );
    }
}
