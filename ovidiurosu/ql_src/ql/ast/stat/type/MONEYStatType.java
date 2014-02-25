package ql.ast.stat.type;

import ql.ast.type.NUMType;

/**
 * Money Statement Type
 * @author orosu
 */
public class MONEYStatType implements IStatType
{
    /**
     * Constructor
     */
    public MONEYStatType()
    {
    }

    @Override
    public NUMType getType()
    {
        return new NUMType();
    }

    @Override
    public String toStr()
    {
        return "money";
    }
}
