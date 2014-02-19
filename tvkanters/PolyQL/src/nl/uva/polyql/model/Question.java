package nl.uva.polyql.model;

public class Question implements IRule {

    public String mId;
    public String mContent;
    public Type mType;

    @Override
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

    public void setType(final String type) {
        setType(Type.valueOf(type.toUpperCase()));
    }

    public String toString() {
        return mId + ": " + mContent + " " + mType;
    }

}
