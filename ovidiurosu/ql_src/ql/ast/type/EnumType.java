package ql.ast.type;

import java.util.ArrayList;
import java.util.List;

import ql.ast.expression.literal.IEnumElement;
import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class EnumType extends Type
{
    private final List<IEnumElement> _elements;

    public EnumType()
    {
        this._elements = new ArrayList<IEnumElement>();
    }

    public void addElement(IEnumElement element)
    {
        this._elements.add(element);
    }

    public List<IEnumElement> getElements()
    {
        return this._elements;
    }

    @Override
    public String toString()
    {
        return "enum";
    }

    @Override
    public boolean compatibleWith(EnumType type)
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
        return type instanceof EnumType;
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
