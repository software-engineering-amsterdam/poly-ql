package ql.ast.stat.type;

import ql.ast.type.STRINGType;

/**
 * Text Statement Type
 * @author orosu
 */
public class TEXTStatType implements IStatType
{
    /**
     * Constructor
     */
    public TEXTStatType()
    {
    }

    @Override
    public STRINGType getType()
    {
        return new STRINGType();
    }

    @Override
    public String toStr()
    {
        return "text";
    }
}
