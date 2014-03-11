package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Type;

public class Variable extends Expression {

    private final String _name;

    private final Expression _value;

    public Variable(final Type type, final String name, final Expression value) {
        _type = type;
        _name = name;
        _value = value;

        _value.setParent(this);
    }

    public Variable(final Type type, final String name) {
        this(type, name, type.getAtom());
    }

    @Override
    public String toString() {
        return "( " + _type.toString() + " " + _name + " " + _value + " )";
    }

    @Override
    public List<ValidationError> validate() {
        return _value.validate();
    }

    private boolean validateType() {
        return true;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Type getType() {
        return _value.getType();
    }
}
