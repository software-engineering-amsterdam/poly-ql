package ql.ast.type;

import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class DateType extends Type
{
    public DateType()
    {
    }

    @Override
    public boolean compatibleWith(DateType type)
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
        return type instanceof DateType;
    }

    @Override
    public String toString()
    {
        return "(type date)";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
