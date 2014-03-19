package main.nl.uva.validation.error;

public abstract class ValidationError {

    private final String _message;

    public ValidationError(final String message) {
        _message = message;
    }

    @Override
    public String toString() {
        return _message;
    }
}
