package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.error.InvalidTypeError;
import main.nl.uva.parser.element.type.Invalid;
import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.element.type.Value.Type;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class Minus extends Expression {

    private final Expression _expression;

    public Minus(final Expression expression, final Line lineInfo) {
        super(lineInfo);
        _expression = expression;
    }

    @Override
    public Value getValue() {
        if (!_expression.getValue().isTypeOf(Type.MONEY)) {
            return new Invalid();
        }

        Money money = (Money) _expression.getValue();
        return new Money(-money.getValue());
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (!_expression.getValue().isTypeOf(Type.MONEY)) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        return valid;
    }
}
