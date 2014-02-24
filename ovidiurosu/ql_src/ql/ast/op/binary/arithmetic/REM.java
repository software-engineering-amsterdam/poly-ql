package ql.ast.op.binary.arithmetic;

import ql.ast.expr.IExpr;
import ql.ast.visitor.IElementVisitor;

/**
 * Reminder
 * @author orosu
 */
public class REM extends Arithmetic
{
    /**
     * Constructor
     * @param leftExpr
     * @param rightExpr
     */
    public REM(IExpr leftExpr, IExpr rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
