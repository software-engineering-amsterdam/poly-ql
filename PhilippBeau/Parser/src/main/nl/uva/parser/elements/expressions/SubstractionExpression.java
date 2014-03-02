package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;

public class SubstractionExpression extends Expression {

    private Expression _right;

    private final Expression _left;

    public SubstractionExpression(final Statement parent, final Expression left) {
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
