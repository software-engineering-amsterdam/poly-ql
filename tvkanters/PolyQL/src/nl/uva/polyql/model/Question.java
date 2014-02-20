package nl.uva.polyql.model;

public class Question extends Rule {

    private final String mId;
    private final String mContent;
    private final Type mType;

    protected Question(final RuleContainer parent, final String id, final String content, final String type) {
        super(parent);

        if (parent.getQuestion(id) != null) {
            throw new RuntimeException("Duplicate rule ID");
        }

        mId = id;
        mContent = content;
        mType = Type.valueOf(type.toUpperCase());
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

    public void setType(final String type) {}

    public Object getValue() {
        return null;
    }

    @Override
    public String toString() {
        return mId + ": " + mContent + " " + mType;
    }

    @Override
    public Question getQuestion(final String id) {
        return getParent().getQuestion(id);
    }

}
