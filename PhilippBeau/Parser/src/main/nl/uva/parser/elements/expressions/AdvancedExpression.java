package main.nl.uva.parser.elements.expressions;

public abstract class AdvancedExpression extends AtomExpression {

    protected Expression _left;
    protected Expression _right;

    public AdvancedExpression(final Expression left, final Expression right) {
        super("");

        _left = left;
        _right = right;

        _left.setParent(this);
        _right.setParent(this);
    }
}