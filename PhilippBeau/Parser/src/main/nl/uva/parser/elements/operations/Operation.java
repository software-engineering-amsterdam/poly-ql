package main.nl.uva.parser.elements.operations;

import main.nl.uva.parser.elements.expressions.Expression;

public abstract class Operation {

    protected final Expression _left;
    protected final Expression _right;

    public Operation(final Expression left, final Expression right) {
        _left = left;
        _right = right;
    }

}
