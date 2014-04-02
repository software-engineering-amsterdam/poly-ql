package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Value;

public class Or extends BinaryExpression {

    public Or(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Value calculateValue(final Bool left, final Bool right) {
        return new Bool(left.getValue() || right.getValue());
    }

    @Override
    public String toString() {
        return _left + " || " + _right;
    }
}
