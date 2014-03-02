package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.statements.Statement;

public class Variable extends Type {

    public static enum Types {
        BOOL,
        TEXT,
        MONEY;
    }

    private final String _name;

    public Variable(final Statement parent, final String name) {
        super("Variable", parent);

        _name = name;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setRight(final Expression cEx) {
        // TODO Auto-generated method stub

    }

}
