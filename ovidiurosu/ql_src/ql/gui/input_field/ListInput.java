package ql.gui.input_field;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ql.ast.expression_value.IValue;
import ql.gui.expression_interpreter.ExpressionInterpreter;

/**
 * @author orosu
 */
public class ListInput extends JList<String> implements IInput
{
    private static final long serialVersionUID = 1L;
    private final String _id;

    public ListInput(String id)
    {
        this._id = id;
    }

    @Override
    public JComponent getJComponent()
    {
        return this;
    }

    @Override
    public String getId()
    {
        return this._id;
    }

    @Override
    public IValue getValue()
    {
        // TODO maybe implement list get value
        return null;
    }

    @Override
    public void attachInputListener(ExpressionInterpreter listener)
    {
        //TODO maybe implement list input listener
        this.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent arg0)
            {
            }
        });
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        // TODO maybe implement list set boolean value
    }

    @Override
    public void setStringValue(String value)
    {
        // TODO maybe implement list set sting value
    }

    @Override
    public void setNullValue()
    {
        // TODO maybe implement list set null value
    }
}
