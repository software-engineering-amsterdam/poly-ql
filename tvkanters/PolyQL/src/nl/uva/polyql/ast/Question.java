package nl.uva.polyql.ast;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.utils.Log;
import nl.uva.polyql.validation.ValidationErrors;

public class Question implements Rule {

    private final String mId;
    private final String mLabel;
    private final Type mType;
    private Value<?> mValue;
    private boolean mValueValid = true;
    private LineInfo mLineInfo;

    private final Set<ValueListener> mUpdateListeners = new HashSet<>();

    protected Question(final String id, final String label, final String type) {
        this(id, label, Type.valueOf(type.toUpperCase()));
    }

    protected Question(final String id, final String label, final Type type) {
        mId = id;
        mLabel = StringValue.parse(label).getValue();
        mType = type;

        setValue(mType.getDefaultValue());
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

    @Override
    public Component getView() {
        return mValue.getView(this).getComponent();
    }

    public void addUpdateListener(final ValueListener listener) {
        Log.i("LISTENER " + listener + " ADDED TO " + this);
        mUpdateListeners.add(listener);
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

    @Override
    public ValidationErrors validate() {
        return new ValidationErrors();
    }

    @Override
    public String toString() {
        return mId;
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
    public void setLineInfo(final LineInfo lineInfo) {
        mLineInfo = lineInfo;
    }

    @Override
    public LineInfo getLineInfo() {
        return mLineInfo;
    }

    /**
     * The interface for that must be implemented to receive call-backs when the question's value is
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
