package ql.gui.component.input_field;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ql.ast.expression.value.IValue;
import ql.ast.type.Type;
import ql.gui.TextFieldTypeValueVisitor;
import ql.gui.listener.DocumentInputListener;
import ql.gui.listener.InputListener;

/**
 * @author orosu
 */
public class TextFieldInput extends JTextField implements ITextInput
{
    private static final long serialVersionUID = 1L;
    private final Type _type;

    public TextFieldInput(Type type)
    {
        this._type = type;
        this.setColumns(10);
    }

    public Type getType()
    {
        return this._type;
    }

    @Override
    public JComponent getJComponent()
    {
        return this;
    }

    @Override
    public void attachInputListener(InputListener inputListener)
    {
        this.getDocument().addDocumentListener(new DocumentInputListener(inputListener));
    }

    @Override
    public IValue getValue()
    {
        return this._type.accept(new TextFieldTypeValueVisitor(this));
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        // Do nothing!
    }

    @Override
    public void setStringValue(String value)
    {
        this.setText(value);
    }

    @Override
    public void setNullValue()
    {
        this.setText("");
    }
}
