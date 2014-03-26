package ql.ast.expression;

import ql.ast.type.Type;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class ParenthesesExpression extends UnaryExpression implements IExpression
{
    public ParenthesesExpression(IExpression expression)
    {
        super(expression);
    }

    @Override
    public Type getType()
    {
        return this._expression.getType();
    }

    @Override
    public String toString()
    {
        return "(expression ( " + this.getSubExpression().toString() + " ))";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
