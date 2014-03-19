package main.nl.uva.parser.expression.atom;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Text;
import main.nl.uva.validation.type.Value;

public class TextAtom extends AtomExpression {

    public TextAtom() {
        this("", Line.NO_LINE_NUMBER);
    }

    public TextAtom(final Line lineInfo) {
        this("", lineInfo);
    }

    public TextAtom(final String value, final Line lineInfo) {
        this(new Text(value), lineInfo);
    }

    public TextAtom(final Text value, final Line lineInfo) {
        super(lineInfo);
        _value = value;
    }

    public TextAtom(final Text text) {
        this(text, Line.NO_LINE_NUMBER);
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
        return "Text: " + _value;
    }
}
