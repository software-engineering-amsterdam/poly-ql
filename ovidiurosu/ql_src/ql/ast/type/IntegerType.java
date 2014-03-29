package ql.ast.type;

import ql.ast.visitor_elements.INumberTypeElementVisitor;
import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * @author orosu
 */
public class IntegerType extends NumberType
{
    public IntegerType()
    {
    }

    @Override
    public String toString()
    {
        return "(type integer)";
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
