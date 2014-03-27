package main.nl.uva.parser.expression.unary;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.validation.type.Value;

public abstract class UnaryExpression extends Expression {

    public UnaryExpression(final Line lineInfo) {
        super(lineInfo);
    }

    protected Value _value = null;
}
