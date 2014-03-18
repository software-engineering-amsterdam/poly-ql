package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Value;

public class Division extends AdvancedExpression {

    public Division(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public Value calculateType(final Money left, final Money right) {
        return new Money(left.getValue() / right.getValue());
    }

    @Override
    public String toString() {
        return _left + " / " + _right;
    }
}
