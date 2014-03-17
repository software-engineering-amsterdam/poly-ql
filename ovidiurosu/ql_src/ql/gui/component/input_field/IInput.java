package ql.gui.component.input_field;

import ql.ast.expression.value.IValue;
import ql.gui.component.IJComponent;
import ql.gui.listener.IListener;

/**
 * @author orosu
 */
public interface IInput extends IJComponent, IListener
{
    public void setEnabled(boolean enabled);
    public IValue getValue();
    public void setBooleanValue(boolean value);
    public void setStringValue(String value);
    public void setNullValue();
}
