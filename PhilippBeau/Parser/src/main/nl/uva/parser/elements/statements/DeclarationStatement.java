package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Variable;

public class DeclarationStatement extends Statement {

    private final String _function;

    private final Variable _variable;

    public DeclarationStatement(final Variable variable, final String function) {
        _function = function;
        _variable = variable;

        _variable.setParent(this);
    }

    @Override
    public String toString() {
        return _variable + " " + _function;
    }

    @Override
    public Variable findVariable(final String variableName, final Statement scopeEnd) {
        if (_parent == null) {
            return null;
        }

        return _parent.findVariable(variableName, this);
    }

    @Override
    public boolean validate() {
        return _variable.validate();
    }

    @Override
    public Variable getVariable(final String variableName) {
        if (_variable.getName().equals(variableName)) {
            return _variable;
        }

        return null;
    }
}
