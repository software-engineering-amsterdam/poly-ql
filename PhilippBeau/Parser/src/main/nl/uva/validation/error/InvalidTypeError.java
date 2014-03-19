package main.nl.uva.validation.error;

import main.nl.uva.parser.element.Line;

public class InvalidTypeError extends ValidationError {

    public InvalidTypeError(final String expression, final Line lineInfo) {
        super(lineInfo + " Invalid type of \"" + expression + "\"");
    }

}
