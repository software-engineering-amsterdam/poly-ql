package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.type.Type;

public class SimpleStatement extends Statement {

    private final String _function;

    private final Type _type;

    public SimpleStatement(final String id, final Statement parent, final Type type,
            final String function) {
        super(id, parent);
        _function = function;
        _type = type;
    }

    @Override
    public String toString() {
        return "SimpleStatement " + " " + _function + " " + _type;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }
}
