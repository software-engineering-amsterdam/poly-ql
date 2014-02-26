package ql.ast.op.binary;
import ql.ast.expr.IExpr;
import ql.ast.op.IOp;

/**
 * Binary Operator
 * @author orosu
 */
public abstract class BinaryOp implements IOp
{
    /**
     * Left Expression
     */
    private final IExpr _leftExpr;

    /**
     * Right Expression
     */
    private final IExpr _rightExpr;

    /**
     * Constructor
     */
    public BinaryOp(IExpr leftExpr, IExpr rightExpr)
    {
        this._leftExpr = leftExpr;
        this._rightExpr = rightExpr;
    }

    /**
     * Get Left Expression
     * @return
     */
    public IExpr getLeftExpr()
    {
        return this._leftExpr;
    }

    /**
     * Get Right Expression
     * @return
     */
    public IExpr getRightExpr()
    {
        return this._rightExpr;
    }

}
