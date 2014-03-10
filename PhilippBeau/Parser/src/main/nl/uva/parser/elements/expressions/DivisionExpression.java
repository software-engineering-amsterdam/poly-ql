package main.nl.uva.parser.elements.expressions;

public class DivisionExpression extends AdvancedExpression {

    public DivisionExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return _left + " / " + _right;
    }
}
