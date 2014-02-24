package ql.ast.type;

import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;

/**
 * String Type
 * @author orosu
 */
public class STRINGType implements IType
{
    public STRINGType()
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
        return true;
    }

    @Override
    public Boolean compatibleWith(TEXTStatType statType)
    {
        return true;
    }

    @Override
    public String toStr()
    {
        return "string";
    }
}
