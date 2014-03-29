package ql.ast.type;

import ql.ast.expression.literal.IRangeElement;
import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class RangeType extends Type
{
    private final IRangeElement _beginElement;
    private final IRangeElement _endElement;

    public RangeType(IRangeElement beginElement, IRangeElement endElement)
    {
        this._beginElement = beginElement;
        this._endElement = endElement;
    }

    public IRangeElement getBeginElement()
    {
        return this._beginElement;
    }

    public IRangeElement getEndElement()
    {
        return this._endElement;
    }

    @Override
    public boolean compatibleWith(RangeType type)
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
        return type instanceof RangeType;
    }

    @Override
    public String toString()
    {
        return "(type " + this._beginElement.getLiteral().toString() +
               " .. " + this._endElement.getLiteral().toString() + ")";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
