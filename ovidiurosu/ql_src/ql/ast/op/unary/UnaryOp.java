package ql.ast.op.unary;

import ql.ast.expr.IExpr;
import ql.ast.op.IOp;

/**
 * Unary Operator
 * @author orosu
 */
public abstract class UnaryOp implements IOp
{
    /**
     * Expression
     */
    private final IExpr _expr;

    /**
     * Constructor
     */
    public UnaryOp(IExpr expr)
    {
        this._expr = expr;
    }

    /**
     * Get Expression
     * @return
     */
    public IExpr getExpr()
    {
        return this._expr;
    }

}
