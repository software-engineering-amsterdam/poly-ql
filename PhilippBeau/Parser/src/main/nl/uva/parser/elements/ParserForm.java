package main.nl.uva.parser.elements;

public class ParserForm extends Statement {

    public ParserForm(final String id, final Statement parent) {
        super(id, parent);
    }

    @Override
    public String toString() {
        String erg = "";

        for (Statement child : _childrens) {
            erg += child + "\n";
        }

        return erg;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }
}
