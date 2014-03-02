package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.types.Type;

/**
 * @author Ivan
 *         Exception class to use for type checking errors.
 */
public class TypeError extends ASTError {
    private final Type expectedType;
    private final Type actualType;

    public TypeError(String message, ASTNode node, Type expected, Type actual) {
        super(message, node);
        expectedType = expected;
        actualType = actual;
    }

    @Override
    public String toString() {
        return "TYPE ERROR: " + super.toString() +
                "Expected '" + expectedType + "' but got '" + actualType + "'\n";
    }
}
