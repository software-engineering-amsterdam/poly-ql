package main.nl.uva.parser.elements.expressions.atoms;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
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
    public List<ValidationError> validate() {
        return new ArrayList<>();
    }

    @Override
    public Type getType() {
        return _type;
    }

    @Override
    public Object getResult() {
        return _value;
    }
}
