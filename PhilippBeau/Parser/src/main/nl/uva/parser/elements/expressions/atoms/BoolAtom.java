package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class BoolAtom extends AtomExpression {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    public BoolAtom() {
        this("false");
    }

    public BoolAtom(final String value) {
        assert isBoolean(value);
        _value = new Bool(parseBoolean(value));
    }

    public BoolAtom(final Bool value) {
        _value = value;
    }

    private static boolean isBoolean(final String value) {
        return value.toLowerCase().equals(TRUE) || value.toLowerCase().equals(FALSE);
    }

    private static boolean parseBoolean(final String value) {
        return value.toLowerCase().equals(TRUE);
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return new ASTValidation();
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "Bool: " + _value;
    }
}
