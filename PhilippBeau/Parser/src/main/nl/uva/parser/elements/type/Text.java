package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.statements.Statement;

public class Text extends Type {

    public Text(final Statement parent) {
        super("Text", parent);
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
