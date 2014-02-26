package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

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
            throw new RuntimeException("Duplicate rule ID");
        }

        mId = id;
        mLabel = ((StringValue) Type.STRING.parseInput(label)).getValue();
        mType = type;

        setValue(mType.getDefaultValue());
    }

    public String getId() {
        return mId;
    }

    public String getContent() {
        return mLabel;
    }

    public Type getType() {
        return mType;
    }

    public void setValue(final Value<?> value) {
        mValue = value;

        for (final OnUpdateListener valueListener : mUpdateListeners) {
            valueListener.onQuestionUpdate(this);
        }
    }

    public void setValueFromInput(final String input) {
        final Value<?> value = mType.parseInput(input);
        mValueValid = value != null;
        setValue(value);
    }

    public Value<?> getValue() {
        return mValue;
    }

    public boolean isValueValid() {
        return mValueValid;
    }

    public void addUpdateListener(final OnUpdateListener listener) {
        Log.i("LISTENER " + listener + " ADDED TO " + this);
        mUpdateListeners.add(listener);
    }

    @Override
    public String toString() {
        return mId + " = " + mValue;
    }

    public interface OnUpdateListener {

        public void onQuestionUpdate(final Question question);
    }
}
