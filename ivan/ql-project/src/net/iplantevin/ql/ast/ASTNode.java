package net.iplantevin.ql.ast;

import net.iplantevin.ql.ast.visitors.IASTVisitor;

/**
 * Abstract class from which all nodes from the AST should be derived.
 *
 * @author Ivan
 */
public abstract class ASTNode {
    private final LineInfo lineInfo;

    public ASTNode(LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    public abstract void accept(IASTVisitor visitor);

    @Override
    public abstract String toString();
}
