package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;

public class Variable extends Expression {

    private final String _name;

    private final Type _type;

    private final String _value;

    public Variable(final Type type, final String name, final String value) {
        super("Variable");

        _type = type;
        _name = name;
        _value = value;
    }

    @Override
    protected boolean validateImpl() {
        return false;
    }

    @Override
    public void print() {
        System.out.print(_name);
    }

    @Override
    public Type isOfType() {
        return _type;
    }
}
