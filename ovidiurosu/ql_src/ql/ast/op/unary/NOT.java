package ql.ast.op.unary;

import ql.ast.expr.IExpr;
import ql.ast.op.IOp;
import ql.ast.type.BOOLType;
import ql.ast.visitor.IElementVisitor;

/**
 * Logical Complement
 * @author orosu
 */
public class NOT extends UnaryOp implements IOp
{
    public NOT(IExpr expr)
    {
        super(expr);
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
