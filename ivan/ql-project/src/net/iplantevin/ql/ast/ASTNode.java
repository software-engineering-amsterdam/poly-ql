package net.iplantevin.ql.ast;

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
}
