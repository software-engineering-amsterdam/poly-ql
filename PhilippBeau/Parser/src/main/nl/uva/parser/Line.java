package main.nl.uva.parser;

import org.antlr.v4.runtime.Token;

public class Line {

    public static Line NO_LINE_NUMBER = new Line(Integer.MIN_VALUE, Integer.MIN_VALUE);

    private final int _startLine;

    private final int _firstCharPosition;

    public Line(final Token token) {
        _startLine = token.getLine();
        _firstCharPosition = token.getCharPositionInLine();
    }

    public Line(final int startLine, final int firstCharPosition) {
        _startLine = startLine;
        _firstCharPosition = firstCharPosition;
    }

    @Override
    public String toString() {
        return "[" + _startLine + " " + _firstCharPosition + "]";
    }
}
