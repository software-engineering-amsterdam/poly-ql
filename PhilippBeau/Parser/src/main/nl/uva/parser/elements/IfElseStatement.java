package main.nl.uva.parser.elements;

public class IfElseStatement extends Statement {

    private final String _name;

    public IfElseStatement(final String name) {
        _name = name;
    }

    @Override
    public String toString() {
        return "IfElseStatement " + _name;
    }
}
