package ql.ast.expression;

/**
 * @author orosu
 */
public abstract class UnaryExpression implements IExpression
{
    protected final IExpression _expression;

    public UnaryExpression(IExpression expression)
    {
        this._expression = expression;
    }

    public IExpression getExpression()
    {
        return this._expression;
    }
}
