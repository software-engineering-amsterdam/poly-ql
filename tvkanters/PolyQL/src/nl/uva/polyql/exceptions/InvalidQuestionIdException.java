package nl.uva.polyql.exceptions;

public class InvalidQuestionIdException extends ParsingException {

    private static final long serialVersionUID = -8331323445960900687L;

    private final String mId;

    public InvalidQuestionIdException(final String id) {
        super("Invalid question ID: " + id);
        mId = id;
    }

    public String getId() {
        return mId;
    }
}
