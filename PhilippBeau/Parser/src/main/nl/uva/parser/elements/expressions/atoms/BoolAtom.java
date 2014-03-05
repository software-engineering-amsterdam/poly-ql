package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;

public class BoolAtom extends Expression {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    private final boolean _value;

    public BoolAtom() {
        _value = false;
    }

    public BoolAtom(final String value) {

        assert isBoolean(value);
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
}
