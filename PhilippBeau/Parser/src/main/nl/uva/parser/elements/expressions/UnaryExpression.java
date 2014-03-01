package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.operations.Operation;

public class UnaryExpression extends Expression {

    private final String _expression;

    public UnaryExpression(final Operation operation, final String expression) {
        _expression = expression;
    }
}
