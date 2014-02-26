package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Divide
 * @author orosu
 */
public class DIV extends Arithmetic
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public DIV(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
