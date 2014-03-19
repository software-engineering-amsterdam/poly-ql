package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.Line;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Text;
import main.nl.uva.validation.type.Value;

public class Equal extends AdvancedExpression {

    public Equal(final Expression left, final Expression right, final Line lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Value calculateType(final Bool left, final Bool right) {
        return new Bool(left.getValue() == right.getValue());
    }

    @Override
    public Value calculateType(final Money left, final Money right) {
        return new Bool(left.getValue() == right.getValue());
    }

    @Override
    public Value calculateType(final Text left, final Text right) {
        return new Bool(left.getValue() == right.getValue());
    }

    @Override
    public String toString() {
        return _left + " == " + _right;
    }
}
