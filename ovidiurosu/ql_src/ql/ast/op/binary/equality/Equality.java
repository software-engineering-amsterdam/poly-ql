package ql.ast.op.binary.equality;

import ql.ast.expr.IExpr;
import ql.ast.op.binary.BinaryOp;
import ql.ast.type.BOOLType;

/**
 * Equality
 * @author orosu
 */
public abstract class Equality extends BinaryOp
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public Equality(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }
}
