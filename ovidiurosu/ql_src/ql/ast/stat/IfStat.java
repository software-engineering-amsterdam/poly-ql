package ql.ast.stat;

import java.util.List;

import ql.ast.expr.IExpr;
import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.visitor.IElementVisitor;

/**
 * If statement
 * @author orosu
 */
public class IfStat implements IStat
{
    /**
     * If Expression
     */
    private final IExpr _expr;

    /**
     * If Statements
     */
    private final List<IStat> _ifStats;

    /**
     * Else Statements
     */
    private final List<IStat> _elseStats;

    /**
     * Constructor
     */
    public IfStat(IExpr expr, List<IStat> ifStats, List<IStat> elseStats)
    {
        this._expr = expr;
        this._ifStats = ifStats;
        this._elseStats = elseStats;
    }

    /**
     * @return the _expr
     */
    public IExpr getExpr()
    {
        return _expr;
    }

    /**
     * @return the _ifStats
     */
    public List<IStat> getIfStats()
    {
        return _ifStats;
    }

    /**
     * @return the _elseStats
     */
    public List<IStat> getElseStats()
    {
        return _elseStats;
    }

    @Override
    public BOOLEANStatType getStatType()
    {
        return new BOOLEANStatType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
