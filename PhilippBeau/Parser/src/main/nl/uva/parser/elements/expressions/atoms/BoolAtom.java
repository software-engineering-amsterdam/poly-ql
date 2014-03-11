package main.nl.uva.parser.elements.expressions.atoms;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Type;

public class BoolAtom extends Expression {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    private final boolean _value;

    public BoolAtom() {
        this("false");
    }

    public BoolAtom(final String value) {
        assert isBoolean(value);

        _type = new Bool();
        _value = parseBoolean(value);
    }

    private static boolean isBoolean(final String value) {
        return value.toLowerCase().equals(TRUE) || value.toLowerCase().equals(FALSE);
    }

    private static boolean parseBoolean(final String value) {
        return value.toLowerCase().equals(TRUE);
    }

    @Override
    public String toString() {
        return "Bool: " + _value;
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
