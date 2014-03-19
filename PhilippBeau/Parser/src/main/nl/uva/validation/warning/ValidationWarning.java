package main.nl.uva.validation.warning;

public class ValidationWarning {

    private final String _message;

    public ValidationWarning(final String message) {
        _message = message;
    }

    @Override
    public String toString() {
        return _message;
    }
}
