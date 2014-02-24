package ql.ast.op.binary.equality;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Equal to
 * @author orosu
 */
public class EQ extends Equality
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public EQ(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
