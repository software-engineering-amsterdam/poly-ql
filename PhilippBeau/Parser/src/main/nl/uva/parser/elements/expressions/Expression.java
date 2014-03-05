package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Type;

public abstract class Expression extends Statement {

    public Expression(final String id) {
        super(id);
    }

    public abstract Type isOfType();
}