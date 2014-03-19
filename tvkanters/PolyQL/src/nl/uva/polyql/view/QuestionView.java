package nl.uva.polyql.view;

import java.awt.Dimension;
import java.security.InvalidParameterException;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;

public abstract class QuestionView implements Question.ValueListener {

    private static final int PADDING = 10;
    private static final Dimension VIEW_SIZE = new Dimension(FormFrame.WIDTH - PADDING * 4, 30);
    private static final Dimension CONTENT_SIZE = new Dimension(FormFrame.WIDTH / 2 - PADDING * 2, 25);

    private final JPanel mPanel;
    private final Question mQuestion;
    private Value<?> mValue;

    public QuestionView(final Question question) {
        mQuestion = question;

        init();

        setValue(mQuestion.getValue(), true);
        onEditableChanged(mQuestion.isEditable());

        mPanel = new JPanel();
        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.X_AXIS));
        mPanel.setPreferredSize(VIEW_SIZE);

        // Add question label
        final JPanel labelContainer = new JPanel();
        labelContainer.setPreferredSize(CONTENT_SIZE);
        final JLabel label = new JLabel();
        label.setPreferredSize(CONTENT_SIZE);
        label.setText(mQuestion.getLabel());
        labelContainer.add(label);
        mPanel.add(labelContainer);

        // Add question value
        final JPanel valueContainer = new JPanel();
        valueContainer.setPreferredSize(CONTENT_SIZE);
        final JComponent valueComponent = getValueComponent();
        valueComponent.setPreferredSize(CONTENT_SIZE);
        valueContainer.add(valueComponent);
        mPanel.add(valueContainer);
    }

    private void setValue(final Value<?> value, final boolean updateSelf) {
        mValue = value;
        onValidityChanged(value.isValid());

        if (updateSelf && value.isValid()) {
            value.setViewValue(this);
        }
    }

    protected void onNewInput(final Value<?> value) {
        if (!Objects.equals(value, mValue)) {
            setValue(value, false);
            mQuestion.setValue(value);
        }
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        setValue(mQuestion.getValue(), true);
    }

    protected abstract void init();

    protected void onEditableChanged(final boolean enabled) {}

    protected void onValidityChanged(final boolean valid) {}

    public void setComponentValue(final BooleanValue value) {
        throw new InvalidParameterException("Booleans are invalid values for this view");
    }

    public void setComponentValue(final NumberValue value) {
        throw new InvalidParameterException("Numbers are invalid values for this view");
    }

    public void setComponentValue(final StringValue value) {
        throw new InvalidParameterException("Strings are invalid values for this view");
    }

    protected abstract JComponent getValueComponent();

    public JComponent getComponent() {
        return mPanel;
    }

}