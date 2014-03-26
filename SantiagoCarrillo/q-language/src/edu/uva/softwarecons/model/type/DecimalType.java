package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/25/14
 */
public class DecimalType
    extends NumericType
{


    @Override
    public String toString()
    {
        return "decimal";
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitDecimalType( this );
    }
}
