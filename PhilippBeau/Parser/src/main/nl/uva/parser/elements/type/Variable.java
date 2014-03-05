package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;

public class Variable extends Expression {

    private final String _name;

    private final Type.Of _type;

    private final Expression _value;

    public Variable(final Type.Of type, final String name, final Expression value) {
        _type = type;
        _name = name;
        _value = value;
    }

    public Variable(final Type.Of type, final String name) {
        this(type, name, Type.Of.getAtomFor(type));
    }

    @Override
    public String toString() {
        return "( " + _type.toString() + " " + _name + " " + _value + " )";
    }
}
