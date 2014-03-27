package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;

public class Addition extends BinaryExpression {

    public Addition(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Value calculateValue(final Money left, final Money right) {
        return new Money(left.getValue() + right.getValue());
    }

    @Override
    public String toString() {
        return _left + " + " + _right;
    }
}
