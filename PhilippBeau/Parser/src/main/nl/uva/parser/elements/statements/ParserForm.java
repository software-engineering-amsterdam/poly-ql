package main.nl.uva.parser.elements.statements;

public class ParserForm extends Statement {

    public ParserForm(final String id, final Statement parent) {
        super(id, parent);
    }

    @Override
    public String toString() {
        return _id;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }
}
