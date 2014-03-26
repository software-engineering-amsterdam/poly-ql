package ql.ast.type;

import ql.ast.visitor_elements.INumberTypeElementVisitor;
import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class DecimalType extends NumberType
{
    public DecimalType()
    {
    }

    @Override
    public String toString()
    {
        return "(type decimal)";
    }

    @Override
    public <T> T accept(ITypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(INumberTypeElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
