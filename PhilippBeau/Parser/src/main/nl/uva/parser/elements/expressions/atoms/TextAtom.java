package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.type.Type;

public class TextAtom extends Expression {

    private final String _value;

    public TextAtom() {
        this("");
    }

    public TextAtom(final String value) {
        _type = new Text();
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

    @Override
    public Type getType() {
        return _type;
    }
}
