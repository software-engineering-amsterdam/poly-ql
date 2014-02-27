package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.QLASTNode;

/**
 * @author Ivan
 */
public class UndefinedError extends ASTError {
    public UndefinedError(String message, QLASTNode node) {
        super(message, node);
    }

    @Override
    public String toString() {
        return "Undefined exception: " + super.toString();
    }
}
