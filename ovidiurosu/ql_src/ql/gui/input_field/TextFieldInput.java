package ql.gui.input_field;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ql.ast.expression_evaluator.TextValueGetterVisitor;
import ql.ast.expression_value.IValue;
import ql.ast.type.Type;
import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.input_listener.DocumentInputListener;

/**
 * @author orosu
 */
public class TextFieldInput extends JTextField implements IInput
{
    private static final long serialVersionUID = 1L;
    private final String _id;
    private final Type _type;

    public TextFieldInput(String id, Type type)
    {
        this.setColumns(10);
        this._id = id;
        this._type = type;
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
        return this._type.accept(new TextValueGetterVisitor(this.getText()));
    }

    @Override
    public void attachInputListener(ExpressionInterpreter expressionInterpreter)
    {
        this.getDocument().addDocumentListener(new DocumentInputListener(this, expressionInterpreter));
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
