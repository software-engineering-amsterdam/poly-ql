package ql.ast.op.binary.relational;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Greater than
 * @author orosu
 */
public class GT extends Relational
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public GT(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
