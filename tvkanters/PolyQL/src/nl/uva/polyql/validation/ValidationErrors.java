package nl.uva.polyql.validation;

import java.util.LinkedList;
import java.util.List;

public class ValidationErrors {
    private final List<ValidationError> mErrors = new LinkedList<>();

    public void add(final ValidationError error) {
        mErrors.add(error);
    }

    public void merge(final ValidationErrors errors) {
        mErrors.addAll(errors.mErrors);
    }

    public boolean isFatal() {
        for (final ValidationError error : mErrors) {
            if (error.isFatal()) {
                return true;
            }
        }
        return false;
    }

    public List<ValidationError> getErrors() {
        return mErrors;
    }

}
