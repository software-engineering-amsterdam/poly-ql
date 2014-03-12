package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Variable;

public abstract class BlockStatement extends Statement {

    @Override
    public Variable getVariable(final String variableName) {
        return null;
    }

    protected void setParentForChildren(final List<Statement> children) {
        for (Statement child : children) {
            child.setParent(this);
        }
    }

}
