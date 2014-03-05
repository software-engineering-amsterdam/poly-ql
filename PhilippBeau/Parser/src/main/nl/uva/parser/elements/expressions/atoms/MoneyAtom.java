package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;

public class MoneyAtom extends Expression {

    private final double _value;

    public MoneyAtom() {
        _value = 0.0d;
    }

    public MoneyAtom(final String value) {
        _value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return "Money: " + _value;
    }
}
