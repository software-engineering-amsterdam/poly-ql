package main.nl.uva.parser.elements;

public class ExpressionStatement extends Statement {

    public ExpressionStatement(final String id, final Statement parent) {
        super(id, parent);
    }

    @Override
    public String toString() {
        return "ExpressionStatement " + _id;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }

}
