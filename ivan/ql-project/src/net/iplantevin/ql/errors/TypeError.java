package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.QLASTNode;
import net.iplantevin.ql.ast.types.Type;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 20-02-14
 * Exception class to use for type checking errors.
 */
public class TypeError extends ASTError {
    private final Type expectedType;
    private final Type actualType;

    public TypeError(String message, QLASTNode node, Type expected, Type actual) {
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
