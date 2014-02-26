package net.iplantevin.ql.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author Ivan
 */
public class LineInfo {
    private final int line;
    private final int charOffsetInLine;

    public LineInfo(int line, int offset) {
        this.line = line;
        charOffsetInLine = offset + 1;
    }

    public LineInfo(ParserRuleContext ctx) {
        line = ctx.getStart().getLine();
        charOffsetInLine = ctx.getStart().getCharPositionInLine() + 1;
    }

    public LineInfo(TerminalNode node) {
        line = node.getSymbol().getLine();
        charOffsetInLine = node.getSymbol().getCharPositionInLine() + 1;
    }

    public int getLine() {
        return line;
    }

    public int getCharOffsetInLine() {
        return charOffsetInLine;
    }

    @Override
    public String toString() {
        return String.format("[%d:%d]", line, charOffsetInLine);
    }
}
