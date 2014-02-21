package ql.ast.type;

import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;

/**
 * Boolean Type
 * @author orosu
 */
public class BOOLType implements IType
{
    /**
     * Constructor
     */
    public BOOLType()
    {
    }

    @Override
    public Boolean compatibleWith(BOOLEANStatType statType)
    {
        return true;
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
        return "bool";
    }
}
