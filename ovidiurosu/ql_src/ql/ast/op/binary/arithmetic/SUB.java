package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Subtract
 * @author orosu
 */
public class SUB extends Arithmetic
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public SUB(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
