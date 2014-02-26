package nl.uva.polyql.exceptions;

public class DuplicateQuestionIdException extends ParsingException {

    private static final long serialVersionUID = -10149099570217767L;

    private final String mId;

    public DuplicateQuestionIdException(final String id) {
        super("Duplicate question ID: " + id);
        mId = id;
    }

    public String getId() {
        return mId;
    }
}
