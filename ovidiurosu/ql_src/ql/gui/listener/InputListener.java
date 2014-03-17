package ql.gui.listener;

import ql.ast.expression.value.IValue;
import ql.gui.element.expression.ExpressionEvaluator;
import ql.gui.element.expression.ValueInterpreterVisitor;

/**
 * @author orosu
 */
public class InputListener
{
    private final ExpressionEvaluator _expressionEvaluator;
    private final ValueInterpreterVisitor _valueInterpreterVisitor;

    public InputListener(ExpressionEvaluator expressionEvaluator,
        ValueInterpreterVisitor valueInterpreterVisitor)
    {
        this._expressionEvaluator = expressionEvaluator;
        this._valueInterpreterVisitor = valueInterpreterVisitor;

        this.evaluateInterpretExpression();
    }

    public IValue evaluateExpression()
    {
        return this._expressionEvaluator.evaluate();
    }

    public void interpretExpression(IValue value)
    {
        value.accept(this._valueInterpreterVisitor);
    }

    public void evaluateInterpretExpression()
    {
        this.interpretExpression(this.evaluateExpression());
    }
}
