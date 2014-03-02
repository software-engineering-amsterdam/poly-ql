package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.type.Variable.Types;

public class DeclarationStatement extends Statement {

    private final String _function;

    private final Types _type;

    public DeclarationStatement(final String id, final Statement parent, final Types type,
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
