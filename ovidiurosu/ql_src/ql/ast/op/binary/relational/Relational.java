package ql.ast.op.binary.relational;

import ql.ast.expr.IExpr;
import ql.ast.op.binary.BinaryOp;
import ql.ast.type.BOOLType;

/**
 * Relational
 * @author orosu
 */
public abstract class Relational extends BinaryOp
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public Relational(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }
}
