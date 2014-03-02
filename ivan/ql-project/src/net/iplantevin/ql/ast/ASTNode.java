package net.iplantevin.ql.ast;

import net.iplantevin.ql.ast.visitors.IASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Interface that should be implemented by all nodes from the AST.
 *
 * @author Ivan
 */
public abstract class ASTNode {
    private final LineInfo lineInfo;

    public ASTNode(ParserRuleContext ctx) {
        this.lineInfo = new LineInfo(ctx);
    }

    public ASTNode(LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    public String printLineInfo() {
        return lineInfo.toString();
    }

    public abstract void accept(IASTVisitor visitor);

    @Override
    public abstract String toString();
}
