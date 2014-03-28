package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;

/**
 * Abstract class for errors. Named ASTError because it must contain a node
 * from the AST (which will me used for messages).
 *
 * @author Ivan
 */
public abstract class ASTError {
    private final String message;
    private final ASTNode node;

    protected ASTError(String message, ASTNode node) {
        this.message = message;
        this.node = node;
    }

    public LineInfo getLineInfo() {
        return node.getLineInfo();
    }

    public ASTNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return message + "\nAt location " + getLineInfo() + ":\n" + node + "\n";
    }
}
