package main.nl.uva.parser.elements;

public class SimpleStatement extends Statement {

    private final String _name;

    public SimpleStatement(final String name) {
        _name = name;
    }

    @Override
    public String toString() {
        return "SimpleStatement " + _name;
    }
}
