package ql.gui.widget;

import ql.gui.Label;
import ql.gui.QuestionnaireFrame;
import ql.gui.input_field.IInput;
import ql.gui.input_listener.InputListenerLinker;

/**
 * @author orosu
 */
public class ComputedLabelInputPair extends LabelInputPair implements IWidgetListener
{
    private final InputListenerLinker _inputListenerLinker;

    public ComputedLabelInputPair(QuestionnaireFrame questionnaireFrame,
        String id, Label label, IInput input, InputListenerLinker widget)
    {
        super(questionnaireFrame, id, label, input);
        this.setEnabled(false);
        this._inputListenerLinker = widget;
    }

    public void setEnabled(boolean enabled)
    {
        this.getInput().setEnabled(enabled);
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (this._inputListenerLinker.evaluateNull()) {
            super.setVisible(false);
            return;
        }
        super.setVisible(visible);
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
}
