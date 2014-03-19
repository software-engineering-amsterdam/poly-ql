package main.nl.uva.parser.element.expression.atom;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.type.Value;

public abstract class AtomExpression extends Expression {

    public AtomExpression(final Line lineInfo) {
        super(lineInfo);
    }

    protected Value _value = null;
}
