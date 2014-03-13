package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class NotExpression extends Expression {

    private final Expression _expression;

    public NotExpression(final Expression expression) {
        _expression = expression;
    }

    @Override
    public Value getValue() {
        return _expression.getValue();
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return _expression.validate(scope);
    }
}
