package ql.ast.type;

import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;

/**
 * Number Type
 * @author orosu
 */
public class NUMType implements IType
{
    public NUMType()
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
        return false;
    }

    @Override
    public String toStr()
    {
        return "num";
    }
}
