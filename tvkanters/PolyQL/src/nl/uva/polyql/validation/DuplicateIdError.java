package nl.uva.polyql.validation;

public class DuplicateIdError extends ValidationError {

    private final String mId;

    public DuplicateIdError(final String id) {
        mId = id;
    }

    @Override
    public String toString() {
        return "Duplicate question ID: " + mId;
    }
}
