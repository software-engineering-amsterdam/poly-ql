package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.model.types.StringType;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;
import nl.uva.polyql.validation.ValidationErrors;
import nl.uva.polyql.view.ValueView;

public class Question implements Rule {

    private final RuleContainer mParent;

    private final String mId;
    private final String mLabel;
    private final Type mType;
    private Value<?> mValue;
    private boolean mValueValid = true;

    private final Set<ValueListener> mUpdateListeners = new HashSet<>();
    private final Set<VisibilityListener> mVisibilityListeners = new HashSet<>();

    protected Question(final RuleContainer parent, final String id, final String label, final String type) {
        this(parent, id, label, Type.valueOf(type.toUpperCase()));
    }

    protected Question(final RuleContainer parent, final String id, final String label, final Type type) {
        mParent = parent;

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

    @Override
    public RuleContainer getParent() {
        return mParent;
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

        for (final ValueListener listener : mUpdateListeners) {
            listener.onQuestionUpdate(this);
        }

        return mValueValid;
    }

    public Value<?> getValue() {
        return mValue;
    }

    public boolean isValueValid() {
        return mValueValid;
    }

    public boolean isEditable() {
        return true;
    }

    public ValueView getView() {
        final ValueView view = mValue.getView(this);
        mVisibilityListeners.add(view);
        view.onParentVisibilityUpdate(isVisible());
        return view;
    }

    public void addUpdateListener(final ValueListener listener) {
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
    public boolean isVisible() {
        return getParent().isVisible();
    }

    @Override
    public void onParentVisibilityUpdate(final boolean visible) {
        for (final VisibilityListener listener : mVisibilityListeners) {
            listener.onParentVisibilityUpdate(visible);
        }
    }

    @Override
    public ValidationErrors validate() {
        return new ValidationErrors();
    }

    @Override
    public String toString() {
        return mId + " = " + mValue;
    }

    /**
     * The interface for that must be implemented to receive callbacks when the question's value is
     * update, e.g., when the user types in the question's field.
     */
    public interface ValueListener {

        /**
         * Called when the question's value is updated. E.g., when the user types in the question's
         * field.
         * 
         * @param question
         *            The question that called the method
         */
        public void onQuestionUpdate(final Question question);
    }

}
