package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;

public class DivisionExpression extends Expression {

    private final Expression _left;
    private Expression _right;

    public DivisionExpression(final Statement parent, final Expression left) {
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
