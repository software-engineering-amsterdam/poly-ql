package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;

public class TextAtom extends Expression {

    private final String _value;

    public TextAtom() {
        _value = "";
    }

    public TextAtom(final String value) {
        _value = value;
    }

    @Override
    public String toString() {
        return "Text: " + _value;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
