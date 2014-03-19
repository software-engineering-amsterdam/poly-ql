package ql.gui.element.widget;

import ql.gui.component.Label;
import ql.gui.component.input_field.IInput;
import ql.gui.element.QuestionnaireFrame;

/**
 * @author orosu
 */
public class ComputedLabelInputPair extends LabelInputPair implements IWidgetListener
{
    private final Widget _widget;

    public ComputedLabelInputPair(QuestionnaireFrame questionnaireFrame,
        String id, Label label, IInput input, Widget widget)
    {
        super(questionnaireFrame, id, label, input);
        this._widget = widget;
    }

    public void setEnabled(boolean enabled)
    {
        this.input.setEnabled(enabled);
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (this._widget.evaluateNull()) {
            super.setVisible(false);
            return;
        }
        super.setVisible(visible);
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
}
