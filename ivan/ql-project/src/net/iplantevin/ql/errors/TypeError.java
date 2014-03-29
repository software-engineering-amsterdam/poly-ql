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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeError typeError = (TypeError) o;

        if (!actualType.equals(typeError.actualType)) return false;
        if (!expectedType.equals(typeError.expectedType)) return false;
        if (!getNode().equals(((TypeError) o).getNode())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expectedType.hashCode();
        result = 31 * result + actualType.hashCode();
        result = 31 * result + getNode().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TYPE ERROR: " + super.toString() +
                "Expected '" + expectedType + "' but got '" + actualType + "'\n";
    }
}
