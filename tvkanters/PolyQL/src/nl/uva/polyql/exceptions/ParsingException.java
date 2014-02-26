package nl.uva.polyql.exceptions;

public class ParsingException extends RuntimeException {

    private static final long serialVersionUID = 7786677349955782952L;

    public ParsingException(final String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
