package net.iplantevin.exceptions;

/**
 * @author Ivan
 */
public abstract class QLException extends Exception {
    public QLException(String message) {
        super(message);
    }

    public QLException(String message, Throwable cause) {
        super(message, cause);
    }

    public QLException(Throwable cause) {
        super(cause);
    }
}
