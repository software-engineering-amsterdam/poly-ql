package ql.ast.expr;

import ql.ast.type.IType;
import ql.ast.visitor.IElementVisitor;

/**
 * Parentheses Expression
 * @author orosu
 */
public class ParensExpr implements IExpr
{
    /**
     * Expression
     */
    private final IExpr _expr;

    /**
     * Constructor
     */
    public ParensExpr(IExpr expr)
    {
        this._expr = expr;
    }

    @Override
    public IType getType()
    {
        return this._expr.getType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
