package ql.ast.op.binary.relational;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Less than
 * @author orosu
 */
public class LT extends Relational
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public LT(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
