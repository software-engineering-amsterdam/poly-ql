package ql.ast.visitor_elements;

import ql.ast.expression.Id;
import ql.ast.expression.ParenthesesExpression;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Remainder;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.arithmetic.UnaryMinus;
import ql.ast.expression.arithmetic.UnaryPlus;
import ql.ast.expression.comparison.Equal;
import ql.ast.expression.comparison.GreaterThan;
import ql.ast.expression.comparison.GreaterThanEqual;
import ql.ast.expression.comparison.LessThan;
import ql.ast.expression.comparison.LessThanEqual;
import ql.ast.expression.comparison.NotEqual;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.NumberLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.logical.LogicalAnd;
import ql.ast.expression.logical.LogicalOr;
import ql.ast.expression.logical.Not;

/**
 * @author orosu
 */
public interface IExpressionElementVisitor<T>
{
    public T visit(Id id);
    public T visit(ParenthesesExpression parenthesesExpression);
    public T visit(Add add);
    public T visit(Divide divide);
    public T visit(Multiply multiply);
    public T visit(Remainder remainder);
    public T visit(Subtract subtract);
    public T visit(LogicalAnd logicalAnd);
    public T visit(LogicalOr logicalOr);
    public T visit(Equal equal);
    public T visit(NotEqual notEqual);
    public T visit(GreaterThan greaterThan);
    public T visit(GreaterThanEqual greaterThanEqual);
    public T visit(LessThan lessThan);
    public T visit(LessThanEqual lessThanEqual);
    public T visit(Not not);
    public T visit(UnaryMinus unaryMinus);
    public T visit(UnaryPlus unaryPlus);
    public T visit(BooleanLiteral booleanLiteral);
    public T visit(NumberLiteral numberLiteral);
    public T visit(StringLiteral stringLiteral);
}
