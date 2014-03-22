package ql.ast.type;

import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class StringType extends Type
{
    public StringType()
    {
    }

    @Override
    public boolean compatibleWith(StringType type)
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
        return type instanceof StringType;
    }

    @Override
    public String toString()
    {
        return "(type string)";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
