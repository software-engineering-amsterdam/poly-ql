package main.nl.uva.parser.elements.statements;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Variable;

public abstract class Statement {

    protected Statement _parent;

    public void setParent(final Statement parent) {
        _parent = parent;
    }

    public abstract List<ValidationError> validate();

    public abstract Variable findVariable(final String variableName, final Statement scopeEnd);

    public abstract Variable getVariable(final String variableName);

    public abstract JPanel getLayout();

    protected static Variable findVariableInChildren(final List<Statement> children, final String variableName, final Statement scopeEnd) {
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

    protected static List<ValidationError> validateStatements(final List<Statement> statements) {
        List<ValidationError> valid = new ArrayList<>();
        for (Statement child : statements) {
            valid.addAll(child.validate());
        }

        return valid;
    }
}
