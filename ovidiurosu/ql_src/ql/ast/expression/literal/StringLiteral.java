package ql.ast.expression.literal;

import ql.ast.type.StringType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class StringLiteral extends Literal<String> implements IEnumElement
{
    public StringLiteral(String value)
    {
        super(value);
    }

    @Override
    public StringType getType()
    {
        return new StringType();
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
