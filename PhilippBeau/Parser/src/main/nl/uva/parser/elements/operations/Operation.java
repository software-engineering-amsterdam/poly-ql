package main.nl.uva.parser.elements.operations;

import main.nl.uva.parser.elements.expressions.AtomExpression;

public abstract class Operation {

    protected final AtomExpression _left;
    protected final AtomExpression _right;

    public Operation(final AtomExpression left, final AtomExpression right) {
        _left = left;
        _right = right;
    }

}
