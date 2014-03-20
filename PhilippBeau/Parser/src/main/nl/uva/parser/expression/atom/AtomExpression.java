package main.nl.uva.parser.expression.atom;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.validation.type.Value;

public abstract class AtomExpression extends Expression {

    public AtomExpression(final Line lineInfo) {
        super(lineInfo);
    }

    protected Value _value = null;
}
