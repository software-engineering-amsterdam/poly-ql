package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class Not extends Expression {

    private final Expression _expression;

    public Not(final Expression expression) {
        _expression = expression;
    }

    @Override
    public Value getValue() {
        Bool bool = (Bool) _expression.getValue();
        return new Bool(!bool.getValue());
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return _expression.validate(scope);
    }
}
