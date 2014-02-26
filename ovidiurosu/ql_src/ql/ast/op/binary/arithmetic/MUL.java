package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Multiply
 * @author orosu
 */
public class MUL extends Arithmetic
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public MUL(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
