package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;

import static main.nl.uva.parser.Utils.available;

public class SimpleExpression extends Expression {

    private final Expression _expression;

    private Expression _right;

    public SimpleExpression(final Statement parent, final Expression expression) {
        super(parent);
        _expression = expression;
    }

    public Expression addRight(final Expression expression) {
        if (!available(_right)) {
            _right = expression;
        }

        return _right;
    }

    @Override
    public String toString() {
        return "SimpleExpression :" + _expression;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setRight(final Expression cEx) {
        // TODO Auto-generated method stub

    }
}
