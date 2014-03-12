package main.nl.uva.parser.elements.expressions;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.ParserElement;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Value;

public abstract class Expression extends ParserElement {

    protected Value _value = null;

    private final List<ExpressionChangeListener> _listener = new ArrayList<>();

    public Expression() {}

    public abstract Value getValue();

    public boolean register(final ExpressionChangeListener listener) {
        return _listener.add(listener);
    }

    @Override
    public final void recalculateValue() {
        recalculateValueImpl();

        for (ExpressionChangeListener listener : _listener) {
            listener.onChange();
        }
    }

    protected abstract void recalculateValueImpl();

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