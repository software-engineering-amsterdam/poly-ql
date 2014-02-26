package net.iplantevin.ast;

import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * Interface that should be implemented by all nodes from the AST.
 */
public abstract class QLASTNode {
    private final LineInfo lineInfo;

    public QLASTNode(ParserRuleContext ctx) {
        this.lineInfo = new LineInfo(ctx);
    }

    public QLASTNode(LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    public String printLineInfo() {
        return lineInfo.toString();
    }

    public abstract void accept(IQLASTVisitor visitor);

    @Override
    public abstract String toString();
}
