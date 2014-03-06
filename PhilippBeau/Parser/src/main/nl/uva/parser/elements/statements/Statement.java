package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Variable;

public abstract class Statement {

    protected Statement _parent;

    public void setParent(final Statement parent) {
        _parent = parent;
    }

    public boolean validate() {
        return true;
    }

    public abstract Variable findVariable(String variableName);

    protected static Variable findVariableInChildren(final List<Statement> children,
            final String variableName) {
        Variable result = null;
        for (Statement statement : children) {
            if (statement instanceof DeclarationStatement
                    || statement instanceof ExpressionStatement) {
                result = statement.findVariable(variableName);
            }

            if (result != null) {
                return result;
            }
        }

        return result;
    }
}
