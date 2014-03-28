package ql.ast.expression_evaluator;

import ql.ast.expression.BinaryExpression;
import ql.ast.expression.Id;
import ql.ast.expression.IdSet;
import ql.ast.expression.ParenthesesExpression;
import ql.ast.expression.UnaryExpression;
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
public class ExpressionIdSetBuilderVisitor implements IExpressionElementVisitor<IdSet>
{
    public ExpressionIdSetBuilderVisitor()
    {
    }

    @Override
    public IdSet visit(Id id)
    {
        IdSet idSet = new IdSet();
        idSet.add(id);
        return idSet;
    }

    @Override
    public IdSet visit(Add add)
    {
        return this._getIdSetFromBinaryExpression(add);
    }

    @Override
    public IdSet visit(Divide divide)
    {
        return this._getIdSetFromBinaryExpression(divide);
    }

    @Override
    public IdSet visit(Multiply multiply)
    {
        return this._getIdSetFromBinaryExpression(multiply);
    }

    @Override
    public IdSet visit(Remainder remainder)
    {
        return this._getIdSetFromBinaryExpression(remainder);
    }

    @Override
    public IdSet visit(Subtract subtract)
    {
        return this._getIdSetFromBinaryExpression(subtract);
    }

    @Override
    public IdSet visit(LogicalAnd logicalAnd)
    {
        return this._getIdSetFromBinaryExpression(logicalAnd);
    }

    @Override
    public IdSet visit(LogicalOr logicalOr)
    {
        return this._getIdSetFromBinaryExpression(logicalOr);
    }

    @Override
    public IdSet visit(Equal equal)
    {
        return this._getIdSetFromBinaryExpression(equal);
    }

    @Override
    public IdSet visit(NotEqual notEqual)
    {
        return this._getIdSetFromBinaryExpression(notEqual);
    }

    @Override
    public IdSet visit(GreaterThan greaterThan)
    {
        return this._getIdSetFromBinaryExpression(greaterThan);
    }

    @Override
    public IdSet visit(GreaterThanEqual greaterThanEqual)
    {
        return this._getIdSetFromBinaryExpression(greaterThanEqual);
    }

    @Override
    public IdSet visit(LessThan lessThan)
    {
        return this._getIdSetFromBinaryExpression(lessThan);
    }

    @Override
    public IdSet visit(LessThanEqual lessThanEqual)
    {
        return this._getIdSetFromBinaryExpression(lessThanEqual);
    }

    @Override
    public IdSet visit(Not not)
    {
        return this._getIdSetFromUnaryExpression(not);
    }

    @Override
    public IdSet visit(UnaryMinus unaryMinus)
    {
        return this._getIdSetFromUnaryExpression(unaryMinus);
    }

    @Override
    public IdSet visit(UnaryPlus unaryPlus)
    {
        return this._getIdSetFromUnaryExpression(unaryPlus);
    }

    @Override
    public IdSet visit(ParenthesesExpression parenthesesExpression)
    {
        return this._getIdSetFromUnaryExpression(parenthesesExpression);
    }

    @Override
    public IdSet visit(BooleanLiteral booleanLiteral)
    {
        return new IdSet();
    }

    @Override
    public IdSet visit(NumberLiteral numberLiteral)
    {
        return new IdSet();
    }

    @Override
    public IdSet visit(StringLiteral stringLiteral)
    {
        return new IdSet();
    }

    private IdSet _getIdSetFromBinaryExpression(BinaryExpression binaryExpression)
    {
        IdSet leftIdSet = binaryExpression.getLeftSubExpression().accept(this);
        IdSet rightIdSet = binaryExpression.getRightSubExpression().accept(this);
        leftIdSet.addAll(rightIdSet);
        return leftIdSet;
    }

    private IdSet _getIdSetFromUnaryExpression(UnaryExpression unaryExpression)
    {
        return unaryExpression.getSubExpression().accept(this);
    }
}
