package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Text;
import main.nl.uva.validation.type.Value;

public class UnEqual extends BinaryExpression {

    public UnEqual(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Value calculateValue(final Bool left, final Bool right) {
        return new Bool(left.getValue() != right.getValue());
    }

    @Override
    public Value calculateValue(final Money left, final Money right) {
        return new Bool(left.getValue() != right.getValue());
    }

    @Override
    public Value calculateValue(final Text left, final Text right) {
        return new Bool(!left.getValue().equals(right.getValue()));
    }

    @Override
    public String toString() {
        return _left + " != " + _right;
    }
}
