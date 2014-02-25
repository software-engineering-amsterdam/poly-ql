package main.nl.uva.parser.elements;

public class ExpressionStatement extends Statement {

    private final String _name;

    public ExpressionStatement(final String name) {
        _name = name;
    }

    @Override
    public String toString() {
        return "ExpressionStatement " + _name;
    }

}
