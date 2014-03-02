package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.statements.Statement;

public abstract class Type extends Expression {

    protected Statement _expression = null;

    private final String _typeName;

    public Type(final String typeName, final Statement parent) {
        super(parent);
        _typeName = typeName;
    }

    @Override
    public String toString() {
        return _typeName + (_expression != null ? _expression : "");
    }
}
