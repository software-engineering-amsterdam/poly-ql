package main.nl.uva.validation.error;

import main.nl.uva.parser.Line;

public class VariableNotFoundError extends ValidationError {

    public VariableNotFoundError(final String variableName, final Line lineInfo) {
        super(lineInfo + " Variable \"" + variableName + "\" not found");
    }

}
