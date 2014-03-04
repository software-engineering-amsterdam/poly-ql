package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.type.Variable.Types;

public class DeclarationStatement extends Statement {

    private final String _function;

    private final Types _type;

    public DeclarationStatement(final String id, final Types type, final String function) {
        super(id);
        _function = function;
        _type = type;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }

    @Override
    public void print() {
        System.out.println(_id + " " + _function + " " + _type);

    }
}
