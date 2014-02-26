package main.nl.uva.parser.elements.statements;

public class SimpleStatement extends Statement {

    private final String _function;

    private final String _type;

    public SimpleStatement(final String id, final Statement parent, final String type,
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
