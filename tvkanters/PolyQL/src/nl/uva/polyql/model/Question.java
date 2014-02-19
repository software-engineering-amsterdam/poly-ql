package nl.uva.polyql.model;

public class Question extends Rule {

    public String mId;
    public String mContent;
    public Type mType;

    public String getId() {
        return mId;
    }

    public void setId(final String name) {
        mId = name;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(final String content) {
        mContent = content;
    }

    public Type getType() {
        return mType;
    }

    public void setType(final Type type) {
        mType = type;
    }

    public String toString() {
        return mId + ": " + mContent + " " + mType;
    }

}
