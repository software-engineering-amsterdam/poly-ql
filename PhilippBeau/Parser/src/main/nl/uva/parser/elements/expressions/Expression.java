package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Type;

public abstract class Expression extends Statement {

    protected Type.Of _type = null;

    public Expression() {}

    public Type.Of getType() {
        // if (_type == null) {
        // _type = findType();
        // }

        return _type;
    }

    // protected abstract Type.Of findType();

    @Override
    public abstract boolean validate();

    @Override
    public Variable findVariable(final String _variableName) {
        return null;
    }
}