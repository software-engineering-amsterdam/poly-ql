package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.op.binary.BinaryOp;
import ql.ast.type.NUMType;

/**
 * Arithmetic
 * @author orosu
 */
public abstract class Arithmetic extends BinaryOp
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public Arithmetic(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public NUMType getType()
    {
        return new NUMType();
    }
}
