package ql.gui.component.input_field;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;

import ql.ast.expression.value.IValue;
import ql.gui.listener.InputListener;

import com.toedter.calendar.JCalendar;

/**
 * @author orosu
 */
public class CalendarInput extends JCalendar implements ITextInput
{
    private static final long serialVersionUID = 1L;

    public CalendarInput()
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
        //TODO implement calendar input listener
        this.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent e)
            {
            }
        });
    }

    @Override
    public IValue getValue()
    {
        // TODO implement calendar get value
        return null;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        // TODO implement calendar set boolean value
    }

    @Override
    public void setStringValue(String value)
    {
        // TODO implement calendar set string value
    }

    @Override
    public void setNullValue()
    {
        // TODO implement calendar set null value
    }
}
