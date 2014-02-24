package ql.ast.op.binary.equality;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Not Equal to
 * @author orosu
 */
public class NEQ extends Equality
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public NEQ(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
