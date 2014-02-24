package ql.ast.stat.type;

import ql.ast.type.BOOLType;

/**
 * Boolean Statement Type
 * @author orosu
 */
public class BOOLEANStatType implements IStatType
{
    /**
     * Constructor
     */
    public BOOLEANStatType()
    {
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }

    @Override
    public String toStr()
    {
        return "boolean";
    }
}
