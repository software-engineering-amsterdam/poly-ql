package ql.gui.input_field;

import javax.swing.JComponent;

import ql.ast.expression_value.IValue;
import ql.gui.expression_interpreter.ExpressionInterpreter;

/**
 * @author orosu
 */
public interface IInput
{
    public void setVisible(boolean visible);
    public void setEnabled(boolean enabled);

    public JComponent getJComponent();
    public String getId();
    public IValue getValue();

    public void setBooleanValue(boolean value);
    public void setStringValue(String value);
    public void setNullValue();

    public void attachInputListener(ExpressionInterpreter expressionInterpreter);
}
