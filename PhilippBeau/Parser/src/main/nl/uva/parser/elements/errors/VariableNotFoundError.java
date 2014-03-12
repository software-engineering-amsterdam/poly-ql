package main.nl.uva.parser.elements.errors;

public class VariableNotFoundError extends ValidationError {

    public VariableNotFoundError(final String variableName) {
        super("Variable " + variableName + " not found");
    }

}
