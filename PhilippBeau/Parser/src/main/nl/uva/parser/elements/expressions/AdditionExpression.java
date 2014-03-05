package main.nl.uva.parser.elements.expressions;

public class AdditionExpression extends AdvancedExpression {

    public AdditionExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return _left + " + " + _right;
    }
}
