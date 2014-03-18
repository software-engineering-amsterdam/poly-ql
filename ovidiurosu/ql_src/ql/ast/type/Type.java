package ql.ast.type;

import ql.ast.visitor_elements.IElement;
import ql.ast.visitor_elements.ITypeElement;

/**
 * @author orosu
 */
public abstract class Type implements IElement, ITypeElement
{
    public abstract boolean compatibleWith(Type type);

    /*
     * ATTENTION!!! All compatibilities are set to false
     * If it is compatible, @Override method in child class
     */
    public boolean compatibleWith(BooleanType type)
    {
        return false;
    }

    public boolean compatibleWith(NumberType type)
    {
        return false;
    }

    public boolean compatibleWith(DateType type)
    {
        return false;
    }

    public boolean compatibleWith(StringType type)
    {
        return false;
    }

    public boolean compatibleWith(EnumType type)
    {
        return false;
    }

    public boolean compatibleWith(RangeType type)
    {
        return false;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object type);
}
