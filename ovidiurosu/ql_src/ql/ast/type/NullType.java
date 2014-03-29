package ql.ast.type;

import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * Used when the type is unknown or undefined
 * @author orosu
 */
public class NullType extends Type
{
    public NullType()
    {
    }

    @Override
    public boolean compatibleWith(Type type)
    {
        return type.compatibleWith(this);
    }

    @Override
    public boolean equals(Object type)
    {
        return type instanceof NullType;
    }

    @Override
    public String toString()
    {
        return "(type null)";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
