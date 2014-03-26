package ql.gui.widget;

import ql.gui.Label;
import ql.gui.QuestionnaireFrame;
import ql.gui.input_field.IInput;

/**
 * @author orosu
 */
public class LabelInputPair implements IWidget
{
    private final String _id;
    private final Label _label;
    private final IInput _input;
    private final QuestionnaireFrame _questionnaireFrame; // used by frame.pack() after setVisible

    public LabelInputPair(QuestionnaireFrame questionnaireFrame,
        String id, Label label, IInput input)
    {
        this._id = id;
        this._label = label;
        this._input = input;
        this._questionnaireFrame = questionnaireFrame;
    }

    public String getId()
    {
        return this._id;
    }

    public Label getLabel()
    {
        return this._label;
    }

    public IInput getInput()
    {
        return this._input;
    }

    public void setVisible(boolean visible)
    {
        this._label.setVisible(visible);
        this._input.setVisible(visible);
        this._questionnaireFrame.pack();
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        this.setVisible(value);
        this._input.setBooleanValue(value);
    }

    @Override
    public void setStringValue(String value)
    {
        this.setVisible(true);
        this._input.setStringValue(value);
    }

    @Override
    public void setNullValue()
    {
        this.setVisible(false);
        this._input.setNullValue();
    }

    @Override
    public void hide()
    {
        this.setVisible(false);
    }
}
