package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Variable;

public abstract class Statement {

    protected Statement _parent;

    public void setParent(final Statement parent) {
        _parent = parent;
    }

    public abstract boolean validate();

    public abstract Variable findVariable(final String variableName, final Statement scopeEnd);

    public abstract Variable getVariable(final String variableName);

    protected static Variable findVariableInChildren(final List<Statement> children,
            final String variableName, final Statement scopeEnd) {
        Variable result = null;
        for (Statement statement : children) {
            if (statement == scopeEnd) {
                return null;
            }

            result = statement.getVariable(variableName);

            if (result != null) {
                return result;
            }
        }

        return null;
    }

    protected static boolean validateStatements(final List<Statement> statements) {
        boolean valid = true;
        for (Statement child : statements) {
            valid = child.validate() && valid;
        }

        return valid;
    }
}
