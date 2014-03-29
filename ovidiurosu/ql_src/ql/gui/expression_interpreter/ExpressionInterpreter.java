package ql.gui.expression_interpreter;

import ql.ast.expression.IExpression;
import ql.ast.expression_evaluator.ExpressionEvaluatorVisitor;
import ql.ast.expression_evaluator.ValueEnvironment;
import ql.ast.expression_value.IValue;
import ql.ast.expression_value.NullValue;
import ql.gui.QuestionnaireFrame;
import ql.gui.widget.IWidget;

/**
 * @author orosu
 */
public class ExpressionInterpreter
{
    private final QuestionnaireFrame _questionnaireFrame; // used to set and clear header error messages
    private final ValueEnvironment _valueEnvironment; // used by InputListener to set value
    private final IExpression _expression;
    private final ValueInterpreterVisitor _valueInterpreterVisitor;

    public ExpressionInterpreter(QuestionnaireFrame questionnaireFrame,
        ValueEnvironment valueEnvironment, IExpression expression, IWidget widget)
    {
        this._questionnaireFrame = questionnaireFrame;
        this._valueEnvironment = valueEnvironment;
        this._expression = expression;
        this._valueInterpreterVisitor = new ValueInterpreterVisitor(widget);

        this.evaluateAndInterpret();
    }

    public void setValue(String id, IValue value)
    {
        this._valueEnvironment.setValue(id, value);
    }

    public IValue evaluate()
    {
        IValue value;

        try {
            //TODO maybe implement a smarter way to clear header messages
            this._questionnaireFrame.clearHeaderMessages();

            value = this._expression.accept(new ExpressionEvaluatorVisitor(this._valueEnvironment));
        } catch (Exception exception) {
            value = new NullValue();
            this._questionnaireFrame.setHeaderMessage(
                exception.getClass().getSimpleName() + "! " + exception.getMessage());
        }
        return value;
    }

    public void interpret(IValue value)
    {
        value.accept(this._valueInterpreterVisitor);
    }

    public void evaluateAndInterpret()
    {
        this.interpret(this.evaluate());
    }
}
