package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Add
 * @author orosu
 */
public class ADD extends Arithmetic
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public ADD(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
