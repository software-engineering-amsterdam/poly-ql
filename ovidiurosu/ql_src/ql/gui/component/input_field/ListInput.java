package ql.gui.component.input_field;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ql.ast.expression.value.IValue;
import ql.gui.listener.InputListener;

/**
 * @author orosu
 */
public class ListInput extends JList<String> implements ISelectableInput
{
    private static final long serialVersionUID = 1L;

    public ListInput()
    {
    }

    @Override
    public JComponent getJComponent()
    {
        return this;
    }

    @Override
    public void attachInputListener(InputListener listener)
    {
        //TODO implement list input listener
        this.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent arg0)
            {
            }
        });
    }

    @Override
    public IValue getValue()
    {
        // TODO implement list get value
        return null;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        // TODO implement list set boolean value
    }

    @Override
    public void setStringValue(String value)
    {
        // TODO implement list set sting value
    }

    @Override
    public void setNullValue()
    {
        // TODO implement list set null value
    }
}
