package ql.gui.expression_interpreter;

import ql.ast.expression_value.BooleanValue;
import ql.ast.expression_value.DecimalValue;
import ql.ast.expression_value.IntegerValue;
import ql.ast.expression_value.NullValue;
import ql.ast.expression_value.StringValue;
import ql.ast.visitor_elements.IValueElementVisitor;
import ql.gui.widget.IWidget;

/**
 * @author orosu
 */
public class ValueInterpreterVisitor implements IValueElementVisitor<Void>
{
    /*
     * The widget that should be affected after an expression is evaluated
     */
    private final IWidget _listenerWidget;

    public ValueInterpreterVisitor(IWidget listenerWidget)
    {
        this._listenerWidget = listenerWidget;
    }

    @Override
    public Void visit(BooleanValue booleanValue)
    {
        this._setBooleanValue(booleanValue.getValue());
        return null;
    }

    @Override
    public Void visit(IntegerValue integerValue)
    {
        this._setStringValue(integerValue.getValue().toString());
        return null;
    }

    @Override
    public Void visit(DecimalValue decimalValue)
    {
        this._setStringValue(decimalValue.getValue().toString());
        return null;
    }

    @Override
    public Void visit(StringValue stringValue)
    {
        this._setStringValue(stringValue.getValue());
        return null;
    }

    @Override
    public Void visit(NullValue nullValue)
    {
        this._setNullValue();
        return null;
    }

    private void _setBooleanValue(boolean value)
    {
        this._listenerWidget.setBooleanValue(value);
    }

    private void _setStringValue(String value)
    {
        this._listenerWidget.setStringValue(value);
    }

    private void _setNullValue()
    {
        this._listenerWidget.setNullValue();
    }
}
