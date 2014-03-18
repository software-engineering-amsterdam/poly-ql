package main.nl.uva.parser.element.expression.atom;

import main.nl.uva.parser.element.type.Text;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class TextAtom extends AtomExpression {

    public TextAtom() {
        this("");
    }

    public TextAtom(final String value) {
        this(new Text(value));
    }

    public TextAtom(final Text value) {
        _value = value;
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
