package net.iplantevin.exceptions;

import net.iplantevin.ast.QLASTNode;

/**
 * @author Ivan
 */
public class QLUndefinedException extends QLASTException {
    public QLUndefinedException(String message, QLASTNode node) {
        super(message, node);
    }

    @Override
    public String toString() {
        return "Undefined exception: " + super.toString();
    }
}
