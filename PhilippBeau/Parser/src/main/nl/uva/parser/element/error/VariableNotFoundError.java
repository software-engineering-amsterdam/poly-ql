package main.nl.uva.parser.element.error;

import main.nl.uva.parser.element.Line;

public class VariableNotFoundError extends ValidationError {

    public VariableNotFoundError(final String variableName, final Line lineInfo) {
        super(lineInfo + " Variable " + variableName + " not found");
    }

}
