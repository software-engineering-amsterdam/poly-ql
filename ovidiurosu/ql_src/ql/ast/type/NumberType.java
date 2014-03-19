package ql.ast.type;

import ql.ast.visitor_elements.INumberTypeElement;

/**
 * @author orosu
 */
public abstract class NumberType extends Type implements INumberTypeElement
{
    public NumberType()
    {
    }

    @Override
    public boolean compatibleWith(NumberType type)
    {
        return true;
    }

    @Override
    public boolean compatibleWith(Type type)
    {
        return type.compatibleWith(this);
    }

    @Override
    public boolean equals(Object type)
    {
        return type instanceof NumberType;
    }
}
