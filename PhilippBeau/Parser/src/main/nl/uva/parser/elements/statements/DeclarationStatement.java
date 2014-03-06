package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Variable;

public class DeclarationStatement extends Statement {

    private final String _function;

    private final Variable _variable;

    public DeclarationStatement(final Variable variable, final String function) {
        _function = function;
        _variable = variable;
    }

    @Override
    public String toString() {
        return _variable + " " + _function;
    }
}
