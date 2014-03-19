package ql.ast.expression.literal;

import ql.ast.type.IntegerType;
import ql.ast.type.NumberType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class IntegerLiteral extends NumberLiteral
{
    public IntegerLiteral(Number value)
    {
        super(value);
    }

    @Override
    public NumberType getType()
    {
        return new IntegerType();
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
