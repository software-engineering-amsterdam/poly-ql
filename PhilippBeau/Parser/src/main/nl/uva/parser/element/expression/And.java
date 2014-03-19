package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.Line;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Value;

public class And extends AdvancedExpression {

    public And(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
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
