package main.nl.uva.parser.element.statement;

import java.util.List;

import main.nl.uva.parser.validation.Scope;

public abstract class BlockStatement extends Statement {

    @Override
    public void removeYourselfFromScope(final Scope scope) {}

    protected static void removeChildrenFromScope(final List<Statement> children, final Scope scope) {
        for (Statement child : children) {
            child.removeYourselfFromScope(scope);
        }
    }
}
