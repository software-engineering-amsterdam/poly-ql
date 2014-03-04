package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AtomExpression;
import main.nl.uva.parser.elements.statements.Statement;

public abstract class Type extends AtomExpression {

    protected Statement _expression = null;

    private final String _typeName;

    public Type(final String typeName) {
        super("");
        _typeName = typeName;
    }

    @Override
    public String toString() {
        return _typeName + (_expression != null ? _expression : "");
    }
}
