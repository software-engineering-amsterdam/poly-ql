package nl.uva.polyql.validation;

public class DuplicateLabelWarning extends ValidationError {

    private final String mLabel;

    public DuplicateLabelWarning(final String label) {
        mLabel = label;
    }

    @Override
    public String toString() {
        return "[Warning] Duplicate question label: " + mLabel;
    }

    @Override
    public boolean isFatal() {
        return false;
    }
}
