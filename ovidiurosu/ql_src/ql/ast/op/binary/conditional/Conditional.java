package ql.ast.op.binary.conditional;

import ql.ast.expr.IExpr;
import ql.ast.op.binary.BinaryOp;
import ql.ast.type.BOOLType;

/**
 * Conditional
 * @author orosu
 */
public abstract class Conditional extends BinaryOp
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public Conditional(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }
}
