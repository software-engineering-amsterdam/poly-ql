package ql.gui.input_field;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ql.ast.expression_value.BooleanValue;
import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.input_listener.ItemInputListener;

/**
 * @author orosu
 */
public class CheckBoxInput extends JCheckBox implements IInput
{
    private static final long serialVersionUID = 1L;
    private final String _id;

    public CheckBoxInput(String id)
    {
        super("Yes");
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
    public BooleanValue getValue()
    {
        return new BooleanValue(this.isSelected());
    }

    @Override
    public void attachInputListener(final ExpressionInterpreter expressionInterpreter)
    {
        this.addItemListener(new ItemInputListener(this, expressionInterpreter));
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        this.setSelected(value);
    }

    @Override
    public void setStringValue(String value)
    {
        assert false: "Execution should never reach this!";
    }

    @Override
    public void setNullValue()
    {
        this.setSelected(false);
    }
}
