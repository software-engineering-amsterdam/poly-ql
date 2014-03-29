package ql.gui.input_field;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;

import ql.ast.expression_value.IValue;
import ql.gui.expression_interpreter.ExpressionInterpreter;

import com.toedter.calendar.JCalendar;

/**
 * @author orosu
 */
public class CalendarInput extends JCalendar implements IInput
{
    private static final long serialVersionUID = 1L;
    private final String _id;

    public CalendarInput(String id)
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
        // TODO maybe implement calendar get value
        return null;
    }

    @Override
    public void attachInputListener(ExpressionInterpreter listener)
    {
        //TODO maybe implement calendar input listener
        this.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent e)
            {
            }
        });
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        // TODO maybe implement calendar set boolean value
    }

    @Override
    public void setStringValue(String value)
    {
        // TODO maybe implement calendar set string value
    }

    @Override
    public void setNullValue()
    {
        // TODO maybe implement calendar set null value
    }
}
