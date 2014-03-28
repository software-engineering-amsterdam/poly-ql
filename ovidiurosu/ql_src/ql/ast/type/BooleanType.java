package ql.ast.type;

import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class BooleanType extends Type
{
    public BooleanType()
    {
    }

    @Override
    public boolean compatibleWith(BooleanType type)
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
        return type instanceof BooleanType;
    }

    @Override
    public String toString()
    {
        return "(type boolean)";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
