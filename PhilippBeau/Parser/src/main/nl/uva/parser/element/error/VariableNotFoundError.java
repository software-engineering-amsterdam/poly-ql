package main.nl.uva.parser.element.error;

public class VariableNotFoundError extends ValidationError {

    public VariableNotFoundError(final String variableName) {
        super("Variable " + variableName + " not found");
    }

}
