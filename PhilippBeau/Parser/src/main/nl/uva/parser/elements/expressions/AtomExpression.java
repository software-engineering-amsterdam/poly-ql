package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.type.Variable.Types;

public abstract class AtomExpression extends Expression {

    protected Types _type;

    public AtomExpression(final String id) {
        super(id);
    }

    @Override
    public Types isOfType() {
        return _type;
    }
}
