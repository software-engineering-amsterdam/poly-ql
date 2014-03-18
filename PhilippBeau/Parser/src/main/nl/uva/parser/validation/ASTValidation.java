package main.nl.uva.parser.validation;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.element.error.ValidationError;

public class ASTValidation {

    private final List<ValidationError> _validationErrors = new ArrayList<>();

    public boolean addError(final ValidationError error) {
        return _validationErrors.add(error);
    }

    public List<ValidationError> getErrors() {
        return _validationErrors;
    }

    public boolean combine(final ASTValidation other) {
        return _validationErrors.addAll(other.getErrors());
    }

    public void printErrors() {
        for (ValidationError error : _validationErrors) {
            System.out.println(error);
        }
    }

    public boolean hasErrors() {
        return !_validationErrors.isEmpty();
    }
}
