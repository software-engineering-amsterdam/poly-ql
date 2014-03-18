package ql.ast.expression;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
//TODO ExpressionIdsVisitor wrap Set<Id> into a new object
public class ExpressionIdsVisitor implements IExpressionElementVisitor<Set<Id>>
{
    public ExpressionIdsVisitor()
    {
    }

    @Override
    public Set<Id> visit(Id id)
    {
        return new HashSet<Id>(Arrays.asList(id));
    }

    @Override
    public Set<Id> visit(Add add)
    {
        Set<Id> leftIds = add.getLeftSubExpression().accept(this);
        Set<Id> rightIds = add.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Divide divide)
    {
        Set<Id> leftIds = divide.getLeftSubExpression().accept(this);
        Set<Id> rightIds = divide.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Multiply multiply)
    {
        Set<Id> leftIds = multiply.getLeftSubExpression().accept(this);
        Set<Id> rightIds = multiply.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Remainder remainder)
    {
        Set<Id> leftIds = remainder.getLeftSubExpression().accept(this);
        Set<Id> rightIds = remainder.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Subtract subtract)
    {
        Set<Id> leftIds = subtract.getLeftSubExpression().accept(this);
        Set<Id> rightIds = subtract.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(LogicalAnd logicalAnd)
    {
        Set<Id> leftIds = logicalAnd.getLeftSubExpression().accept(this);
        Set<Id> rightIds = logicalAnd.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(LogicalOr logicalOr)
    {
        Set<Id> leftIds = logicalOr.getLeftSubExpression().accept(this);
        Set<Id> rightIds = logicalOr.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Equal equal)
    {
        Set<Id> leftIds = equal.getLeftSubExpression().accept(this);
        Set<Id> rightIds = equal.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(NotEqual notEqual)
    {
        Set<Id> leftIds = notEqual.getLeftSubExpression().accept(this);
        Set<Id> rightIds = notEqual.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(GreaterThan greaterThan)
    {
        Set<Id> leftIds = greaterThan.getLeftSubExpression().accept(this);
        Set<Id> rightIds = greaterThan.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(GreaterThanEqual greaterThanEqual)
    {
        Set<Id> leftIds = greaterThanEqual.getLeftSubExpression().accept(this);
        Set<Id> rightIds = greaterThanEqual.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(LessThan lessThan)
    {
        Set<Id> leftIds = lessThan.getLeftSubExpression().accept(this);
        Set<Id> rightIds = lessThan.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(LessThanEqual lessThanEqual)
    {
        Set<Id> leftIds = lessThanEqual.getLeftSubExpression().accept(this);
        Set<Id> rightIds = lessThanEqual.getRightSubExpression().accept(this);
        leftIds.addAll(rightIds);
        return leftIds;
    }

    @Override
    public Set<Id> visit(Not not)
    {
        return not.getExpression().accept(this);
    }

    @Override
    public Set<Id> visit(UnaryMinus unaryMinus)
    {
        return unaryMinus.getExpression().accept(this);
    }

    @Override
    public Set<Id> visit(UnaryPlus unaryPlus)
    {
        return unaryPlus.getExpression().accept(this);
    }

    @Override
    public Set<Id> visit(ParenthesesExpression parensExpression)
    {
        return parensExpression.getExpression().accept(this);
    }

    @Override
    public Set<Id> visit(BooleanLiteral booleanLiteral)
    {
        return new HashSet<Id>();
    }

    @Override
    public Set<Id> visit(NumberLiteral numberLiteral)
    {
        return new HashSet<Id>();
    }

    @Override
    public Set<Id> visit(StringLiteral stringLiteral)
    {
        return new HashSet<Id>();
    }
}
