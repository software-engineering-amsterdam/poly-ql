package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;

public class AndExpression extends Expression {

    private Expression _right;

    private final Expression _left;

    public AndExpression(final Statement parent, final Expression left) {
        super(parent);
        _left = left;
    }

    public void setRight(final Expression right) {
        _right = right;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

}
