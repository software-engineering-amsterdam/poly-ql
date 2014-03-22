package ql.ast.type;

/**
 * @author orosu
 */
public class MoneyType extends DecimalType
{
    public MoneyType()
    {
    }

    @Override
    public String toString()
    {
        return "(type money)";
    }
}
