package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Variable;

public class ExpressionStatement extends Statement {

    private final Variable _variable;

    private final String _function;

    public ExpressionStatement(final Variable variable, final String function) {

        _function = function;
        _variable = variable;
    }

    @Override
    public String toString() {
        return _variable + " " + _function;
    }

    @Override
    public Variable findVariable(final String _variableName) {
        if (_variable.getName().equals(_variableName)) {
            return _variable;
        }

        return null;
    }
}
