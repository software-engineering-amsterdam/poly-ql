package main.nl.uva.parser.elements.statements;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.ASTNode;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.ui.UIElement;

public abstract class Statement extends ASTNode {

    @Override
    public abstract List<ValidationError> validate();

    @Override
    public abstract Variable findVariable(final String variableName, final ASTNode scopeEnd);

    public abstract Variable getVariable(final String variableName);

    public abstract UIElement getLayout();

    @Override
    public void recalculateValue() {

    }

    protected static Variable findVariableInChildren(final List<Statement> children, final String variableName, final ASTNode scopeEnd) {
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
