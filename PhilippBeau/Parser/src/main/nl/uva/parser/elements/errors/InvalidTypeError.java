package main.nl.uva.parser.elements.errors;

public class InvalidTypeError extends ValidationError {

    public InvalidTypeError(final String expression) {
        super("Invalid type of " + expression);
    }

}
