package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Type;

public class MoneyAtom extends Expression {

    private final double _value;

    public MoneyAtom() {
        this("0.0");
    }

    public MoneyAtom(final String value) {
        _type = new Money();
        _value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return "Money: " + _value;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Type getType() {
        return _type;
    }

}
