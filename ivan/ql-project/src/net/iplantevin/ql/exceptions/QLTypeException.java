package net.iplantevin.exceptions;

import net.iplantevin.ast.QLASTNode;
import net.iplantevin.ast.types.Type;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 20-02-14
 * Exception class to use for type checking errors.
 */
public class QLTypeException extends QLASTException {
    private final Type expectedType;
    private final Type actualType;

    public QLTypeException(String message, QLASTNode node, Type expected, Type actual) {
        super(message, node);
        expectedType = expected;
        actualType = actual;
    }

    @Override
    public String toString() {
        return "Type exception: " + super.toString() +
                "Expected '" + expectedType + "' but got '" + actualType + "'.";
    }
}
