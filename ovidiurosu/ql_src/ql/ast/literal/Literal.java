package ql.ast.literal;

import ql.ast.expr.IExpr;

/**
 * Literal Abstract
 * @author orosu
 */
public abstract class Literal<T> implements IExpr
{
    private final T _value;

    /**
     * Constructor
     */
    public Literal(T value)
    {
        this._value = value;
    }

    /**
     * Get Literal
     * @return
     */
    public T getLiteral()
    {
        return this._value;
    }
}
