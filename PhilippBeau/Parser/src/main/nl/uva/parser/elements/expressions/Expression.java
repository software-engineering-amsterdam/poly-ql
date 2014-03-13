package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.ParserElement;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Value;

public abstract class Expression extends ParserElement {

    protected Value _value = null;

    public Expression() {}

    public abstract Value getType();

    @Override
    public abstract List<ValidationError> validate();

    @Override
    public Variable findVariable(final String variableName, final ParserElement scopeEnd) {
        if (_parent != null) {
            return _parent.findVariable(variableName, this);
        }

        return null;
    }
}