package nl.uva.polyql.view;

import java.awt.Component;
import java.util.Objects;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.VisibilityListener;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public abstract class ValueView implements Question.ValueListener, VisibilityListener {

    private final Question mQuestion;
    private Value<?> mValue;

    public ValueView(final Question question) {
        mQuestion = question;

        init();

        setValue(mQuestion.getValue(), true);
        setEditable(mQuestion.isEditable());
    }

    protected void onNewInput(final Value<?> value) {
        if (!Objects.equals(value, mValue)) {
            setValue(value, false);
            mQuestion.setValue(value);
        }
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        setValue(question.getValue(), true);
    }

    @Override
    public void onParentVisibilityUpdate(final boolean visible) {
        getComponent().setVisible(visible);
    }

    public Question getQuestion() {
        return mQuestion;
    }

    protected abstract void init();

    public abstract Component getComponent();

    private void setValue(final Value<?> value, final boolean updateSelf) {
        mValue = value;
        setValid(value != null);

        if (updateSelf && value != null) {
            value.setViewValue(this);
        }
    }

    public abstract void setComponentValue(BooleanValue value);

    public abstract void setComponentValue(NumberValue value);

    public abstract void setComponentValue(StringValue value);

    public abstract void setEditable(boolean enabled);

    protected abstract void setValid(boolean valid);

}