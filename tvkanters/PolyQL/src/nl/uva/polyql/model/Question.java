package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.exceptions.DuplicateQuestionIdException;
import nl.uva.polyql.model.types.StringType;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;
import nl.uva.polyql.view.ValueView;

public class Question extends Rule {

    private final String mId;
    private final String mLabel;
    private final Type mType;
    private Value<?> mValue;
    private boolean mValueValid = true;

    private final Set<OnUpdateListener> mUpdateListeners = new HashSet<>();

    protected Question(final RuleContainer parent, final String id, final String label, final String type) {
        this(parent, id, label, Type.valueOf(type.toUpperCase()));
    }

    protected Question(final RuleContainer parent, final String id, final String label, final Type type) {
        super(parent);

        if (parent.getQuestion(id) != null) {
            throw new DuplicateQuestionIdException(id);
        }

        mId = id;
        mLabel = StringType.parseInputToString(label);
        mType = type;

        setValue(mType.getType().getDefaultValue());
    }

    public String getId() {
        return mId;
    }

    public String getLabel() {
        return mLabel;
    }

    public Type getType() {
        return mType;
    }

    /**
     * Sets this question's value and determines if the value is valid.
     * 
     * @param value
     *            The new value
     * 
     * @return True iff the value is valid (not null)
     */
    public boolean setValue(final Value<?> value) {
        if (value != null) {
            mValue = value;
            mValueValid = true;
        } else {
            mValueValid = false;
        }

        for (final OnUpdateListener valueListener : mUpdateListeners) {
            valueListener.onQuestionUpdate(this);
        }

        return mValueValid;
    }

    /**
     * Sets this question's value and determines if the value is valid. The string given will be
     * parsed to the appropriate format.
     * 
     * @param input
     *            The value that the end-user entered
     * 
     * @return True iff the value is valid (not null)
     */
    public boolean setValueFromInput(final String input) {
        return setValue(mType.getType().parseInput(input));
    }

    /**
     * @return The question's value or null if it's invalid
     */
    public Value<?> getValue() {
        return mValue;
    }

    public boolean isValueValid() {
        return mValueValid;
    }

    public boolean isEditable() {
        return true;
    }

    public ValueView<?> getView() {
        return mValue.getView(this);
    }

    public void addUpdateListener(final OnUpdateListener listener) {
        Log.i("LISTENER " + listener + " ADDED TO " + this);
        mUpdateListeners.add(listener);
    }

    @Override
    public List<Question> getQuestions() {
        final List<Question> questions = new LinkedList<>();
        questions.add(this);
        return questions;
    }

    @Override
    public String toString() {
        return mId + " = " + mValue;
    }

    /**
     * The interface for that must be implemented to receive callbacks when the question's value is
     * update, e.g., when the user types in the question's field.
     */
    public interface OnUpdateListener {

        /**
         * Called when the question's value is update, e.g., when the user types in the question's
         * field.
         */
        public void onQuestionUpdate(final Question question);
    }
}
