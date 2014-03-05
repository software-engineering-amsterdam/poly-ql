package main.nl.uva.parser.elements.type;

public class Bool extends Type {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    private boolean _value = false;

    public Bool() {
        super(Type.Of.BOOLEAN);
    }

    public Bool(final String value) {
        super(Type.Of.BOOLEAN);

        assert isBoolean(value);
        _value = parseBoolean(value);
    }

    private static boolean isBoolean(final String value) {
        return value.toLowerCase().equals(TRUE) || value.toLowerCase().equals(FALSE);
    }

    private static boolean parseBoolean(final String value) {
        return value.toLowerCase().equals(TRUE);
    }
}
