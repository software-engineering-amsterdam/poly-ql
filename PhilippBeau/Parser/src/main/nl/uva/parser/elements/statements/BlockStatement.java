package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.validation.Scope;

public abstract class BlockStatement extends Statement {

    @Override
    public void removeYourselfFromScope(final Scope scope) {}

    protected static void removeChildrenFromScope(final List<Statement> children, final Scope scope) {
        for (Statement child : children) {
            child.removeYourselfFromScope(scope);
        }
    }
}
