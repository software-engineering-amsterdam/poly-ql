package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.Line;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;

public class Multiplication extends AdvancedExpression {

    public Multiplication(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
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
