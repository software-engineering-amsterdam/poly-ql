package nl.uva.polyql.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class LineInfo {

    private final int mLine;
    private final int mCharOffset;

    public LineInfo(final ParserRuleContext ctx) {
        final Token start = ctx.start;
        mLine = start.getLine();
        mCharOffset = start.getCharPositionInLine();
    }

    public int getLine() {
        return mLine;
    }

    public int getCharOffsetInLine() {
        return mCharOffset;
    }

    @Override
    public String toString() {
        return "[" + mLine + ":" + mCharOffset + "]";
    }
}