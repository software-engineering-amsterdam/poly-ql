package ql.gui.element.widget;

import ql.gui.component.Label;
import ql.gui.component.input_field.IInput;
import ql.gui.element.QuestionnaireFrame;

/**
 * @author orosu
 */
public class LabelInputPair implements IWidget
{
    public String id;
    public Label label;
    public IInput input;
    private final QuestionnaireFrame _questionnaireFrame;

    public LabelInputPair(QuestionnaireFrame questionnaireFrame,
        String id, Label label, IInput input)
    {
        this.id = id;
        this.label = label;
        this.input = input;
        this._questionnaireFrame = questionnaireFrame;
    }

    public void setVisible(boolean visible)
    {
        this.label.setVisible(visible);
        this.input.setVisible(visible);
        this._questionnaireFrame.pack();
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        this.setVisible(value);
        this.input.setBooleanValue(value);
    }

    @Override
    public void setStringValue(String value)
    {
        this.setVisible(true);
        this.input.setStringValue(value);
    }

    @Override
    public void setNullValue()
    {
        this.setVisible(false);
        this.input.setNullValue();
    }

    @Override
    public void hide()
    {
        this.setVisible(false);
    }
}
