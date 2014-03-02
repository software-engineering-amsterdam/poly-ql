package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.statements.Statement;

public class Money extends Type {

    private final String _amount;

    public Money(final Statement parent, final String amount) {
        super("Money", parent);

        _amount = amount;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setRight(final Expression cEx) {
        // TODO Auto-generated method stub

    }
}
