package ql.gui.component.input_field;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ql.ast.expression.value.BooleanValue;
import ql.gui.listener.InputListener;
import ql.gui.listener.ItemInputListener;

/**
 * @author orosu
 */
public class CheckBoxInput extends JCheckBox implements ISelectableInput
{
    private static final long serialVersionUID = 1L;

    public CheckBoxInput(String text)
    {
        super(text);
    }

    @Override
    public JComponent getJComponent()
    {
        return this;
    }

    @Override
    public void attachInputListener(final InputListener inputListener)
    {
        this.addItemListener(new ItemInputListener(inputListener));
    }

    @Override
    public BooleanValue getValue()
    {
        return new BooleanValue(this.isSelected());
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        this.setSelected(value);
    }

    @Override
    public void setStringValue(String value)
    {
        // Do nothing!
    }

    @Override
    public void setNullValue()
    {
        this.setSelected(false);
    }
}
