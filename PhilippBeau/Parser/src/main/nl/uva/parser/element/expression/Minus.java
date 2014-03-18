package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.element.validation.ASTValidation;
import main.nl.uva.parser.element.validation.Scope;

public class Minus extends Expression {

    private final Expression _expression;

    public Minus(final Expression expression) {
        _expression = expression;
    }

    @Override
    public Value getValue() {
        Money money = (Money) _expression.getValue();
        return new Money(-money.getValue());
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return _expression.validate(scope);
    }
}
