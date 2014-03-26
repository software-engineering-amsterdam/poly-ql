package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;

/**
 * @author Ivan
 */
public abstract class ASTWarning {
    private final String message;

    protected ASTWarning(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
