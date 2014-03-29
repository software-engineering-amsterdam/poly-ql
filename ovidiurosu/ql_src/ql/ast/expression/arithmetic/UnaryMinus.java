package ql.ast.expression.arithmetic;

import ql.ast.expression.IExpression;
import ql.ast.expression.UnaryExpression;
import ql.ast.type.IntegerType;
import ql.ast.type.NumberType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class UnaryMinus extends UnaryExpression
{
    public UnaryMinus(IExpression expression)
    {
        super(expression);
    }

    @Override
    public NumberType getType()
    {
        return new IntegerType();
    }

    @Override
    public String toString()
    {
        return "(expression - " + this.getSubExpression().toString() + ")";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
