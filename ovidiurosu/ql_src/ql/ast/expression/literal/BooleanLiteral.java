package ql.ast.expression.literal;

import ql.ast.type.BooleanType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class BooleanLiteral extends Literal<Boolean>
{
    public BooleanLiteral(Boolean value)
    {
        super(value);
    }

    @Override
    public BooleanType getType()
    {
        return new BooleanType();
    }

    @Override
    public String toString()
    {
        return "(expression (booleanLiteralP " + this.getLiteral().toString() + "))";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
