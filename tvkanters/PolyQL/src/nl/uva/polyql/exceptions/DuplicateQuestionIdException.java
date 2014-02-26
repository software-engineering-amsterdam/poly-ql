package nl.uva.polyql.exceptions;

public class DuplicateQuestionIdException extends ParsingException {

    private static final long serialVersionUID = 8634412238170543338L;

    private final String mId;

    public DuplicateQuestionIdException(final String id) {
        super("Duplicate question ID: " + id);
        mId = id;
    }

    public String getId() {
        return mId;
    }
}
