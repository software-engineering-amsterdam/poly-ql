package ql.ast.op.binary.relational;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Greater than or equal
 * @author orosu
 */
public class GTQ extends Relational
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public GTQ(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
