package ql.ast;

import ql.ast.expr.IExpr;
import ql.ast.type.IType;
import ql.ast.type.NULLType;
import ql.ast.visitor.IElementVisitor;

/**
 * ID
 * @author orosu
 */
public class ID implements IExpr
{
    /**
     * ID Value
     */
    private final String _value;

    /**
     * Type
     */
    private IType _type;


    /**
     * Constructor
     */
    public ID(String value)
    {
        this._value = value;
        this._type = new NULLType();
    }

    /**
     * @return the _value
     */
    public String getValue()
    {
        return _value;
    }

    /**
     * Set Type
     * @param type
     */
    public void setType(IType type)
    {
        this._type = type;
    }

    @Override
    public IType getType()
    {
        return this._type;
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }
}
