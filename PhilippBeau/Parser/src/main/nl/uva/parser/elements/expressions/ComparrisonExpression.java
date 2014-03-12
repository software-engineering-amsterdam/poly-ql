package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.type.Value;

public class ComparrisonExpression extends AdvancedExpression {

    public ComparrisonExpression(final Expression left, final Expression right) {
        super(left, right);
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
