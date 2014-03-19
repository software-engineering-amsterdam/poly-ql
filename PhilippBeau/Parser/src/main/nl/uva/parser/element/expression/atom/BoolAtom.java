package main.nl.uva.parser.element.expression.atom;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class BoolAtom extends AtomExpression {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    public BoolAtom() {
        this("false", Line.NO_LINE_NUMBER);
    }

    public BoolAtom(final Line lineInfo) {
        this("false", lineInfo);
    }

    public BoolAtom(final String value, final Line lineInfo) {
        super(lineInfo);

        assert isBoolean(value);
        _value = new Bool(parseBoolean(value));
    }

    public BoolAtom(final Bool value, final Line lineInfo) {
        super(lineInfo);
        _value = value;
    }

    public BoolAtom(final Bool bool) {
        this(bool, Line.NO_LINE_NUMBER);
    }

    public BoolAtom(final String value) {
        this(value, Line.NO_LINE_NUMBER);
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
