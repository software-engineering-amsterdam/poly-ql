package main.nl.uva.parser.elements;

import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Variable;

public abstract class ASTNode {

    protected ASTNode _parent;

    public void setParent(final ASTNode parent) {
        _parent = parent;
    }

    public abstract List<ValidationError> validate();

    public abstract void recalculateValue();

    public abstract Variable findVariable(final String variableName, final ASTNode scopeEnd);
}
