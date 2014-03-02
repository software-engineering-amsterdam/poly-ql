package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;

public abstract class Expression extends Statement {

    public Expression(final Statement parent) {
        super("", parent);
    }

    public abstract void setRight(Expression cEx);

}
