package nl.uva.polyql.validation;

public class UnknownIdError extends ValidationError {

    private final String mId;

    public UnknownIdError(final String id) {
        mId = id;
    }

    @Override
    public String toString() {
        return "Unknown question ID: " + mId;
    }
}
