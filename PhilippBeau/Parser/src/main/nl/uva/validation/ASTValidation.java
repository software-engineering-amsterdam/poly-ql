package main.nl.uva.validation;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.validation.error.ValidationError;
import main.nl.uva.validation.warning.ValidationWarning;

public class ASTValidation {

    private final List<ValidationError> _validationErrors = new ArrayList<>();

    private final List<ValidationWarning> _validationWarnings = new ArrayList<>();

    public boolean addError(final ValidationError error) {
        return _validationErrors.add(error);
    }

    public boolean addWarning(final ValidationWarning warning) {
        return _validationWarnings.add(warning);
    }

    public boolean combine(final ASTValidation other) {
        boolean validError = _validationErrors.addAll(other._validationErrors);
        boolean validWarning = _validationWarnings.addAll(other._validationWarnings);
        return validError && validWarning;
    }

    public boolean hasErrors() {
        return !_validationErrors.isEmpty();
    }

    public boolean hasWarnings() {
        return !_validationWarnings.isEmpty();
    }

    public List<ValidationError> getValidationErrors() {
        return _validationErrors;
    }

    public List<ValidationWarning> getValidationWarnings() {
        return _validationWarnings;
    }

    public void printErrors() {
        for (ValidationError error : _validationErrors) {
            System.err.println(error);
        }
    }

    public void printWarnings() {
        for (ValidationWarning warning : _validationWarnings) {
            System.out.println(warning);
        }
    }
}
