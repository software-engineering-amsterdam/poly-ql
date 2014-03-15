package ql.ast.expression.literal;

import ql.ast.expression.IExpression;

/**
 * @author orosu
 */
public abstract class Literal<T> implements IExpression
{
    private final T _value;

    public Literal(T value)
    {
        this._value = value;
    }

    public T getLiteral()
    {
        return this._value;
    }
}
