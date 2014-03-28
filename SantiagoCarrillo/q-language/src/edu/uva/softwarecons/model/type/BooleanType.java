package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class BooleanType
    implements Type
{


    @Override
    public String toString()
    {
        return "boolean";
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof BooleanType;
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitBooleanType( this );
    }
}
