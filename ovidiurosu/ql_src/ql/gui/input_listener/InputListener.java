package ql.gui.input_listener;

import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.input_field.IInput;

/**
 * @author orosu
 */
public abstract class InputListener
{
    protected final ExpressionInterpreter _expressionInterpreter;
    protected final IInput _input;

    public InputListener(IInput input, ExpressionInterpreter expressionInterpreter)
    {
        this._input = input;
        this._expressionInterpreter = expressionInterpreter;
    }

    protected void _update()
    {
        this._expressionInterpreter.setValue(this._input.getId(), this._input.getValue());
        this._expressionInterpreter.evaluateAndInterpret();
    }
}
