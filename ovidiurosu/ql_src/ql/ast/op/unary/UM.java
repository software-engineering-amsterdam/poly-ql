package ql.ast.op.unary;

import ql.ast.expr.IExpr;
import ql.ast.op.IOp;
import ql.ast.type.NUMType;
import ql.ast.visitor.IElementVisitor;

/**
 * Unary Minus
 * @author orosu
 */
public class UM extends UnaryOp implements IOp
{
    public UM(IExpr expr)
    {
        super(expr);
    }

    @Override
    public NUMType getType()
    {
        return new NUMType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
