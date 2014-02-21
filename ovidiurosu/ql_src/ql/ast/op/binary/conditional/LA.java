package ql.ast.op.binary.conditional;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Logical And
 * @author orosu
 */
public class LA extends Conditional
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public LA(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
