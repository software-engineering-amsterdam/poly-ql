package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Expression;

public class IFStatement extends Statement {

    private final Expression _expression;

    public IFStatement(final Expression expression, final Statement parent) {
        super("", parent);
        _expression = expression;
    }

    @Override
    protected boolean validateImpl() {
        boolean valid = _parent.validates(this);

        if (!valid) {
            System.err.println(this + "Is very very wrong");
        }

        return valid;
    }

    @Override
    public String toString() {
        return "IFStatement " + _id + _expression;
    }
}
