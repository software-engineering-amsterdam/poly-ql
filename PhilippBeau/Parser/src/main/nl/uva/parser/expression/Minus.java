package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Invalid;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;
import main.nl.uva.validation.type.Value.Type;

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
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = _expression.validateAndCalculate(scope);

        if (!_expression.getValue().isTypeOf(Type.MONEY)) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        notifyListenersAboutValueChange();

        return valid;
    }

    @Override
    public String toString() {
        return "-" + _expression;
    }
}
