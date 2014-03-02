package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.type.Variable.Types;

public class ExpressionStatement extends Statement {

    private final Types _type;

    private final String _function;

    public ExpressionStatement(final String id, final Statement parent, final Types type,
            final String function) {
        super(id, parent);

        _function = function;
        _type = type;
    }

    @Override
    public String toString() {
        return "ExpressionStatement " + _id + " : " + _type + " ( " + " )";
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }
}
