package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Value;

public class And extends AdvancedExpression {

    public And(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public Value calculateType(final Bool left, final Bool right) {
        return new Bool(left.getValue() && right.getValue());
    }

    @Override
    public String toString() {
        return _left + " && " + _right;
    }
}
