package main.nl.uva.parser.elements.errors;

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
