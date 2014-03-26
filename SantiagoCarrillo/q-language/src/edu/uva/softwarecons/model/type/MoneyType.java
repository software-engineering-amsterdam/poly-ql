package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class MoneyType
    extends NumericType
{


    @Override
    public String toString()
    {
        return "money";
    }

    @Override
    public void accept( TypeElementVisitor visitor )
    {
        visitor.visitMoneyType( this );
    }
}
