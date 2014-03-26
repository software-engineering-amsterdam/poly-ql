package ql.ast.expression.arithmetic;

import ql.ast.expression.BinaryExpression;
import ql.ast.expression.IExpression;
import ql.ast.type.IntegerType;
import ql.ast.type.NumberType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class Multiply extends BinaryExpression
{
    public Multiply(IExpression leftSubExpression, IExpression rightSubExpression)
    {
        super(leftSubExpression, rightSubExpression);
    }

    @Override
    public NumberType getType()
    {
        return new IntegerType();
    }

    @Override
    public String toString()
    {
        return "(expression " + this.getLeftSubExpression().toString() +
               " * " + this.getRightSubExpression().toString() + ")";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
