package ql.gui.element.widget;

import java.util.LinkedHashSet;

import ql.ast.expression.value.BooleanValue;

/**
 * @author orosu
 */
public class IfElseWidget implements IWidget, IWidgetListener
{
    private final Widget _widget;
    private final LinkedHashSet<IWidget> _ifWidgets;
    private final LinkedHashSet<IWidget> _elseWidgets;

    public IfElseWidget(Widget widget)
    {
        this._widget = widget;
        this._ifWidgets = new LinkedHashSet<IWidget>();
        this._elseWidgets = new LinkedHashSet<IWidget>();
    }

    public void addIfWidget(IWidget widget)
    {
        this._ifWidgets.add(widget);
    }

    public void addElseWidget(IWidget widget)
    {
        this._elseWidgets.add(widget);
    }

    public boolean getValue()
    {
        if (!this._widget.hasInputListener()) {
            assert false: "Before calling getValue, you should always call hasInputListener";
        }
        return ((BooleanValue) this._widget.getInputListener().evaluateExpression()).value;
    }

    @Override
    public void createAttachInputListener()
    {
        this._widget.createAttachInputListener(this);
    }

    @Override
    public Widget getWidget()
    {
        return this._widget;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        if (this._widget.evaluateNull()) {
            for(IWidget widget: this._ifWidgets) {
                widget.setNullValue();
            }
            for(IWidget widget: this._elseWidgets) {
                widget.setNullValue();
            }
            return;
        }

        if (this._widget.hasInputListener()) {
            value = getValue();
        }

        if (value) {
            this._showIf(value);
        } else {
            this._showElse(!value);
        }
    }

    @Override
    public void setStringValue(String value)
    {
        assert false: "Execution should never reach this!";
    }

    @Override
    public void setNullValue()
    {
        for(IWidget widget: this._ifWidgets) {
            widget.setNullValue();
        }
        for(IWidget widget: this._elseWidgets) {
            widget.setNullValue();
        }
    }

    @Override
    public void hide()
    {
        for(IWidget widget: this._ifWidgets) {
            widget.hide();
        }
        for(IWidget widget: this._elseWidgets) {
            widget.hide();
        }
    }

    private void _showIf(boolean value)
    {
        for(IWidget widget: this._ifWidgets) {
            widget.setBooleanValue(value);
        }
        for(IWidget widget: this._elseWidgets) {
            widget.hide();
        }
    }

    private void _showElse(boolean value)
    {
        for(IWidget widget: this._ifWidgets) {
            widget.hide();
        }
        for(IWidget widget: this._elseWidgets) {
            widget.setBooleanValue(value);
        }
    }
}
