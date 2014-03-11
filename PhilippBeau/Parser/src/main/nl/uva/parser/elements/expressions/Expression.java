package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.ParserElement;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Type;

public abstract class Expression extends ParserElement {

    protected Type _type = null;

    public Expression() {}

    public abstract Type getType();

    @Override
    public abstract List<ValidationError> validate();

    @Override
    public Variable findVariable(final String variableName, final ParserElement scopeEnd) {
        if (_parent != null) {
            return _parent.findVariable(variableName, this);
        }

        return null;
    }

    public abstract Object getResult();
}