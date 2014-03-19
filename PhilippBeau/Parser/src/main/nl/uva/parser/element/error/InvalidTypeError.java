package main.nl.uva.parser.element.error;

import main.nl.uva.parser.element.Line;

public class InvalidTypeError extends ValidationError {

    public InvalidTypeError(final String expression, final Line lineInfo) {
        super(lineInfo + " Invalid type of \"" + expression + "\"");
    }

}
