package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Expression;

public class IfElseStatement extends Statement {

    public IfElseStatement(final Expression expression, final Statement parent) {
        super("", parent);
    }

    @Override
    public String toString() {
        return "IfElseStatement ";
    }

    @Override
    protected boolean validateImpl() {

        boolean valid = _parent.validates(this);

        if (!valid) {
            System.err.println(this + "Is very very wrong");
        }

        return valid;
    }
}
