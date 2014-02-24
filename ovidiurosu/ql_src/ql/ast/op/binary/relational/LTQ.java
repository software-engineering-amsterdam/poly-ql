package ql.ast.op.binary.relational;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Less than or equal
 * @author orosu
 */
public class LTQ extends Relational
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public LTQ(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
