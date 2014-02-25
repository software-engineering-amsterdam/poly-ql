package main.nl.uva.parser.elements;

import java.util.List;

public class ParserForm {

    private final String _name;

    private final List<Statement> _blocks;

    public ParserForm(final String name, final List<Statement> ifs) {
        _name = name;
        _blocks = ifs;
    }

    @Override
    public String toString() {
        String erg = _name + "\n";

        for (Statement s : _blocks) {
            erg += s + "\n";
        }

        return erg;
    }
}
