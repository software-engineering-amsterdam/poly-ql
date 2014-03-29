package ql.ast.expression.logical;

import ql.ast.expression.IExpression;
import ql.ast.expression.UnaryExpression;
import ql.ast.type.BooleanType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * Logical Complement
 * @author orosu
 */
public class Not extends UnaryExpression
{
    public Not(IExpression expression)
    {
        super(expression);
    }

    @Override
    public BooleanType getType()
    {
        return new BooleanType();
    }

    @Override
    public String toString()
    {
        return "(expression ! " + this.getSubExpression().toString() + ")";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
