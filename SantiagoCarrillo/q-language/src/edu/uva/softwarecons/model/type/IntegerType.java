package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class IntegerType
    extends NumericType
{


    @Override
    public String toString()
    {
        return "integer";
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitIntegerType( this );
    }
}
