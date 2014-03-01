package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.ExpressionAlreadySetException;
import main.nl.uva.parser.elements.expressions.Expression;

public abstract class Type {

    protected Expression _expression = null;

    private final String _typeName;

    public Type(final String typeName) {
        _typeName = typeName;
    }

    /**
     * Set the expression to the current type. If the expression was already set notify the user
     * 
     * @param expression
     * @throws ExpressionAlreadySetException
     */
    public void addExpression(final Expression expression) throws ExpressionAlreadySetException {
        if (_expression != null) {
            throw new ExpressionAlreadySetException();
        }

        _expression = expression;
    }

    @Override
    public String toString() {
        return _typeName;
    }
}
