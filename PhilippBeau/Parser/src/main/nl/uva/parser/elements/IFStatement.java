package main.nl.uva.parser.elements;

import java.util.List;

public class IFStatement extends Statement {

    private final String _name;

    private final List<Statement> _block;

    public IFStatement(final String name, final List<Statement> ifs) {
        _name = name;
        _block = ifs;
    }

    @Override
    public String toString() {
        String erg = "IFStatement " + _name + "\n";

        for (Statement s : _block) {
            erg += s + "\n";
        }

        return erg;
    }
}
