package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.statements.Statement;

public abstract class Type {

    protected enum Of {
        MONEY,
        BOOLEAN,
        TEXT;
    }

    protected Statement _expression = null;

    private final Type.Of _typeOf;

    public Type(final Type.Of typeOf) {
        _typeOf = typeOf;
    }

    @Override
    public String toString() {
        return _typeOf.toString();
    }
}
