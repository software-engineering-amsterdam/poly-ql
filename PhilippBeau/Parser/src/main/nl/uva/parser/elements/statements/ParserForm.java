package main.nl.uva.parser.elements.statements;

import java.util.List;

public class ParserForm extends Statement {

    private final List<Statement> _children;

    private final String _id;

    public ParserForm(final String id, final List<Statement> children) {

        _id = id;
        _children = children;
    }

    @Override
    public String toString() {
        String erg = _id + "\n";

        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg;
    }
}
