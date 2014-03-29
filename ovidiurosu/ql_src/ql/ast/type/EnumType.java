package ql.ast.type;

import java.util.ArrayList;
import java.util.Iterator;
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

    public Iterator<IEnumElement> getElementsIterator()
    {
        return this._elements.iterator();
    }

    public void addElement(IEnumElement element)
    {
        this._elements.add(element);
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
    public String toString()
    {
        return "(type ( " + this._enumElementsToString(0) + " ))";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    private String _enumElementsToString(int index)
    {
        if (index > this._elements.size() - 1) {
            return "";
        }

        String result = this._enumElementsToString(index + 1);
        return "(enumTypeP " + this._elements.get(index).enumToString() +
               (!result.equals("")? " , " + result: "") + ")";
    }
}
