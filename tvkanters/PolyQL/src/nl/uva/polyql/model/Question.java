package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.Set;

public class Question extends Rule {

    private final String mId;
    private final String mContent;
    private final Type mType;
    private Object mValue;

    private final Set<QuestionUpdatedListener> mUpdateListeners = new HashSet<>();

    protected Question(final RuleContainer parent, final String id, final String content, final String type) {
        super(parent);

        if (parent.getQuestion(id) != null) {
            throw new RuntimeException("Duplicate rule ID");
        }

        mId = id;
        mContent = content;
        mType = Type.valueOf(type.toUpperCase());

        // Set default value
        switch (mType) {
        case BOOLEAN:
            mValue = false;
            break;

        case NUMBER:
            mValue = 0.0;
            break;

        default:
            throw new RuntimeException("Invalid type " + mType);
        }
    }

    /**
     * Retrieves the ID of the rule.
     * 
     * @return The rule's ID
     */
    public String getId() {
        return mId;
    }

    public String getContent() {
        return mContent;
    }

    public Type getType() {
        return mType;
    }

    public void setValue(final Object value) {
        mValue = value;

        for (final QuestionUpdatedListener valueListener : mUpdateListeners) {
            valueListener.onQuestionUpdate(this);
        }
    }

    public Object getValue() {
        return mValue;
    }

    public void addUpdateListener(final QuestionUpdatedListener listener) {
        System.out.println("LISTENER " + listener + " ADDED TO " + this);
        mUpdateListeners.add(listener);
    }

    @Override
    public String toString() {
        return mId + " = " + mValue;
    }

}
