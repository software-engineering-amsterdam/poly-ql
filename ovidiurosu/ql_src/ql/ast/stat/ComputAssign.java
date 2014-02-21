package ql.ast.stat;

import ql.ast.expr.IExpr;
import ql.ast.stat.type.IStatType;
import ql.ast.visitor.IElementVisitor;

/**
 * Computed Assign Statement
 * @author orosu
 */
public class ComputAssign implements IStat, IAssign
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
     * Expression
     */
    private final IExpr _expr;

    /**
     * Constructor
     */
    public ComputAssign(String id, String label, IStatType statType, IExpr expr)
    {
        this._id = id;
        this._label = label;
        this._statType = statType;
        this._expr = expr;
    }

    /**
     * @return the _expr
     */
    public IExpr getExpr()
    {
        return _expr;
    }

    @Override
    public String getId()
    {
        return _id;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    @Override
    public IStatType getStatType()
    {
        return this._statType;
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
