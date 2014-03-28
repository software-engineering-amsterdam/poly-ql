package ql.gui.widget;

import java.util.LinkedHashSet;

import ql.ast.expression_value.BooleanValue;
import ql.gui.input_listener.InputListenerLinker;

/**
 * @author orosu
 */
public class IfElse implements IWidget, IWidgetListener
{
    private final InputListenerLinker _inputListenerLinker;
    private final LinkedHashSet<IWidget> _ifWidgets;
    private final LinkedHashSet<IWidget> _elseWidgets;

    public IfElse(InputListenerLinker inputListenerLinker)
    {
        this._inputListenerLinker = inputListenerLinker;
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
        if (!this._inputListenerLinker.hasExpressionInterpreter()) {
            assert false: "Before calling getValue, you should always call hasInputListener";
        }
        return ((BooleanValue) this._inputListenerLinker.getExpressionInterpreter()
            .evaluate()).getValue();
    }

    @Override
    public void attachInputListener()
    {
        this._inputListenerLinker.attachInputListener(this);
    }

    @Override
    public InputListenerLinker getInputListenerLinker()
    {
        return this._inputListenerLinker;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        if (this._inputListenerLinker.evaluateNull()) {
            for(IWidget widget: this._ifWidgets) {
                widget.setNullValue();
            }
            for(IWidget widget: this._elseWidgets) {
                widget.setNullValue();
            }
            return;
        }

        if (this._inputListenerLinker.hasExpressionInterpreter()) {
            value = this.getValue();
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
