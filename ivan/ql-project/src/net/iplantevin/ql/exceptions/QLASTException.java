package net.iplantevin.exceptions;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.QLASTNode;

/**
 * @author Ivan
 */
public abstract class QLASTException extends QLException {
    private final QLASTNode node;

    protected QLASTException(String message, QLASTNode node) {
        super(message);
        this.node = node;
    }

    public QLASTNode getNode() {
        return node;
    }

    public LineInfo getLineInfo() {
        return node.getLineInfo();
    }

    @Override
    public String toString() {
        return getMessage() + "\n" +
                "At location " + getLineInfo() + ":\n" + node + "\n";
    }
}
