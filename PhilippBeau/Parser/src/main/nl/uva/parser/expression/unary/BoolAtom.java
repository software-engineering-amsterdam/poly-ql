package main.nl.uva.parser.expression.unary;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Value;

public class BoolAtom extends UnaryExpression {

    public BoolAtom() {
        this(new Bool(false), Line.NO_LINE_NUMBER);
    }

    public BoolAtom(final Line lineInfo) {
        this(new Bool(false), lineInfo);
    }

    public BoolAtom(final Bool value, final Line lineInfo) {
        super(lineInfo);
        _value = value;
    }

    public BoolAtom(final Bool bool) {
        this(bool, Line.NO_LINE_NUMBER);
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
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
