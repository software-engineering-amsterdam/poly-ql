package ql.ast.op.unary;

import ql.ast.expr.IExpr;
import ql.ast.op.IOp;
import ql.ast.type.NUMType;
import ql.ast.visitor.IElementVisitor;

/**
 * Unary Plus
 * @author orosu
 */
public class UP extends UnaryOp implements IOp
{
    public UP(IExpr expr)
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
