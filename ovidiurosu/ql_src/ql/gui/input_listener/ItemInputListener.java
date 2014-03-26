package ql.gui.input_listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.input_field.IInput;

/**
 * @author orosu
 */
public class ItemInputListener extends InputListener implements ItemListener
{
    public ItemInputListener(IInput input, ExpressionInterpreter expressionInterpreter)
    {
        super(input, expressionInterpreter);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent)
    {
        this._update();
    }
}
