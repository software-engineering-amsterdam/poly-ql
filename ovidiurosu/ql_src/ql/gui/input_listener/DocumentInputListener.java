package ql.gui.input_listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.input_field.IInput;

/**
 * @author orosu
 */
public class DocumentInputListener extends InputListener implements DocumentListener
{
    public DocumentInputListener(IInput input, ExpressionInterpreter expressionInterpreter)
    {
        super(input, expressionInterpreter);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent)
    {
        this._update();
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent)
    {
        this._update();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent)
    {
        this._update();
    }
}
