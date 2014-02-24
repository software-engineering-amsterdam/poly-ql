package ql.ast.stat;

import ql.ast.stat.type.IStatType;
import ql.ast.visitor.IElementVisitor;

/**
 * Assign
 * @author orosu
 */
public class Assign implements IStat, IAssign
{
    /**
     * ID
     */
    private final String _id;

    /**
     * Label
     */
    private final String _label;

    /**
     * Statement Type
     */
    private final IStatType _statType;

    /**
     * Constructor
     */
    public Assign(String id, String label, IStatType statType)
    {
        this._id = id;
        this._label = label;
        this._statType = statType;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    @Override
    public IStatType getStatType()
    {
        return _statType;
    }

    @Override
    public String getId()
    {
        return _id;
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
