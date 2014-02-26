package ql.ast.type;

import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;

/**
 * NULL Type - used when the type is unknown (undefined)
 * @author orosu
 */
public class NULLType implements IType
{
    /**
     * Constructor
     */
    public NULLType()
    {
    }

    @Override
    public Boolean compatibleWith(BOOLEANStatType statType)
    {
        return false;
    }

    @Override
    public Boolean compatibleWith(MONEYStatType statType)
    {
        return false;
    }

    @Override
    public Boolean compatibleWith(TEXTStatType statType)
    {
        return false;
    }

    @Override
    public String toStr()
    {
        return "NULL";
    }
}
