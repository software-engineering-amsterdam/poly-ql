package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.operations.Operation;
import main.nl.uva.parser.elements.statements.Statement;

public class ComparrisonExpression extends Expression {

    private final Expression _left;
    private final Expression _right;
    private final Operation _operation;

    public ComparrisonExpression(final Statement parent, final Expression left,
            final Expression right, final Operation operation) {
        super(parent);

        _left = left;
        _right = right;
        _operation = operation;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        return "ComparrisonExp: " + _left + " " + _operation + " " + _right;
    }

    @Override
    public void setRight(final Expression cEx) {
        // TODO Auto-generated method stub

    }

}
