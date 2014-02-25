package ql.ast.op.binary.conditional;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Logical Or
 * @author orosu
 */
public class LO extends Conditional
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public LO(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
