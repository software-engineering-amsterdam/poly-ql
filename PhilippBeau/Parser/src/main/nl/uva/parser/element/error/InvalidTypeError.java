package main.nl.uva.parser.element.error;

public class InvalidTypeError extends ValidationError {

    public InvalidTypeError(final String expression) {
        super("Invalid type of " + expression);
    }

}
