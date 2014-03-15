package ql.gui.element.expression;

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
import ql.ast.expression.value.BooleanValue;
import ql.ast.expression.value.IValue;
import ql.ast.expression.value.NullValue;
import ql.ast.expression.value.NumberValue;
import ql.ast.expression.value.StringValue;
import ql.ast.type.NumberType;
import ql.ast.visitor_elements.IExpressionElementVisitor;
import ql.gui.element.QuestionnaireFrame;

/**
 * @author orosu
 */
public class ExpressionEvaluatorVisitor implements IExpressionElementVisitor<IValue>
{
    private final QuestionnaireFrame _questionnaireFrame;

    public ExpressionEvaluatorVisitor(QuestionnaireFrame questionnaireFrame)
    {
        this._questionnaireFrame = questionnaireFrame;
    }

    @Override
    public IValue visit(Id id)
    {
        if (!this._questionnaireFrame.containsLabelInputPair(id.getValue())) {
            return new NullValue();
        }
        return this._questionnaireFrame.getLabelInputPairById(id.getValue())
            .input.getValue();
    }

    @Override
    public IValue visit(Add addition)
    {
        IValue leftValue = addition.getLeftSubExpression().accept(this);
        IValue rightValue = addition.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).add((NumberValue) rightValue);
    }

    @Override
    public IValue visit(Divide divivision)
    {
        IValue leftValue = divivision.getLeftSubExpression().accept(this);
        IValue rightValue = divivision.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).divide((NumberValue) rightValue);
    }

    @Override
    public IValue visit(Multiply multiplication)
    {
        IValue leftValue = multiplication.getLeftSubExpression().accept(this);
        IValue rightValue = multiplication.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).multiply((NumberValue) rightValue);
    }

    @Override
    public IValue visit(Remainder remainder)
    {
        IValue leftValue = remainder.getLeftSubExpression().accept(this);
        IValue rightValue = remainder.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).remainder((NumberValue) rightValue);
    }

    @Override
    public IValue visit(Subtract subtraction)
    {
        IValue leftValue = subtraction.getLeftSubExpression().accept(this);
        IValue rightValue = subtraction.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).subtract((NumberValue) rightValue);
    }

    @Override
    public BooleanValue visit(LogicalAnd logicalAnd)
    {
        BooleanValue leftValue = (BooleanValue) logicalAnd.getLeftSubExpression().accept(this);
        BooleanValue rightValue = (BooleanValue) logicalAnd.getRightSubExpression().accept(this);

        return leftValue.and(rightValue);
    }

    @Override
    public BooleanValue visit(LogicalOr logicalOr)
    {
        BooleanValue leftValue = (BooleanValue) logicalOr.getLeftSubExpression().accept(this);
        BooleanValue rightValue = (BooleanValue) logicalOr.getRightSubExpression().accept(this);

        return leftValue.or(rightValue);
    }

    @Override
    public BooleanValue visit(Equal equal)
    {
        IValue leftValue = equal.getLeftSubExpression().accept(this);
        IValue rightValue = equal.getRightSubExpression().accept(this);
        return new BooleanValue(leftValue.equal(rightValue));
    }

    @Override
    public IValue visit(NotEqual notEqual)
    {
        IValue leftValue = notEqual.getLeftSubExpression().accept(this);
        IValue rightValue = notEqual.getRightSubExpression().accept(this);
        return new BooleanValue(!leftValue.equal(rightValue));
    }

    @Override
    public IValue visit(GreaterThan greaterThan)
    {
        IValue leftValue = greaterThan.getLeftSubExpression().accept(this);
        IValue rightValue = greaterThan.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).greaterThan((NumberValue) rightValue);
    }

    @Override
    public IValue visit(GreaterThanEqual greaterThanEqual)
    {
        IValue leftValue = greaterThanEqual.getLeftSubExpression().accept(this);
        IValue rightValue = greaterThanEqual.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).greaterThanEqual((NumberValue) rightValue);
    }

    @Override
    public IValue visit(LessThan lessThan)
    {
        IValue leftValue = lessThan.getLeftSubExpression().accept(this);
        IValue rightValue = lessThan.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).lessThan((NumberValue) rightValue);
    }

    @Override
    public IValue visit(LessThanEqual lessThanEqual)
    {
        IValue leftValue = lessThanEqual.getLeftSubExpression().accept(this);
        IValue rightValue = lessThanEqual.getRightSubExpression().accept(this);
        if (leftValue.equals(new NullValue()) || rightValue.equals(new NullValue())) {
            return new NullValue();
        }

        return ((NumberValue) leftValue).lessThanEqual((NumberValue) rightValue);
    }

    @Override
    public IValue visit(Not not)
    {
        IValue value = not.getExpression().accept(this);
        if (value.equals(new NullValue())) {
            return new NullValue();
        }

        return ((BooleanValue) value).not();
    }

    @Override
    public IValue visit(UnaryMinus unaryMinus)
    {
        IValue value = unaryMinus.getExpression().accept(this);

        return ((NumberValue) value).unaryMinus();
    }

    @Override
    public IValue visit(UnaryPlus unaryPlus)
    {
        IValue value = unaryPlus.getExpression().accept(this);

        return ((NumberValue) value).unaryPlus();
    }

    @Override
    public IValue visit(ParenthesesExpression parensExpr)
    {
        return parensExpr.getExpression().accept(this);
    }

    @Override
    public BooleanValue visit(BooleanLiteral booleanLiteral)
    {
        return new BooleanValue(booleanLiteral.getLiteral());
    }

    @Override
    public NumberValue visit(NumberLiteral numberLiteral)
    {
        return ((NumberType) numberLiteral.getType()).accept(
            new NumberTypeValueGetterVisitor(numberLiteral.getLiteral())
        );
    }

    @Override
    public StringValue visit(StringLiteral stringLiteral)
    {
        return new StringValue(stringLiteral.getLiteral());
    }
}
