package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Value;

public class Multiplication extends AdvancedExpression {

    public Multiplication(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public Value calculateType(final Money left, final Money right) {
        return new Money(left.getValue() * right.getValue());
    }

    @Override
    public String toString() {
        return _left + " * " + _right;
    }
}
