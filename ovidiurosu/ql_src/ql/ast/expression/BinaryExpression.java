package ql.ast.expression;

/**
 * @author orosu
 */
public abstract class BinaryExpression implements IExpression
{
    private final IExpression _leftSubExpression;
    private final IExpression _rightSubExpression;

    public BinaryExpression(IExpression leftSubExpression, IExpression rightSubExpression)
    {
        this._leftSubExpression = leftSubExpression;
        this._rightSubExpression = rightSubExpression;
    }

    public IExpression getLeftSubExpression()
    {
        return this._leftSubExpression;
    }

    public IExpression getRightSubExpression()
    {
        return this._rightSubExpression;
    }
}
