package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.ASTNode;

/**
 * @author Ivan
 */
public class UndefinedError extends ASTError {
    public UndefinedError(String message, ASTNode node) {
        super(message, node);
    }

    @Override
    public String toString() {
        return "UNDEFINED ERROR: " + super.toString();
    }
}
