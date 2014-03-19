package ql.ast.expression.literal;

import ql.ast.type.DecimalType;
import ql.ast.type.NumberType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class DecimalLiteral extends NumberLiteral
{
    public DecimalLiteral(Number value)
    {
        super(value);
    }

    @Override
    public NumberType getType()
    {
        return new DecimalType();
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
