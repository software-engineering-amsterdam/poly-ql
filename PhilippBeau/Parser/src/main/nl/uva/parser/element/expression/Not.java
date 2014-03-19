package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Invalid;
import main.nl.uva.validation.type.Value;
import main.nl.uva.validation.type.Value.Type;

public class Not extends Expression {

    private final Expression _expression;

    public Not(final Expression expression, final Line lineInfo) {
        super(lineInfo);
        _expression = expression;
    }

    @Override
    public Value getValue() {
        if (!_expression.getValue().isTypeOf(Type.BOOLEAN)) {
            return new Invalid();
        }

        Bool bool = (Bool) _expression.getValue();
        return new Bool(!bool.getValue());
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (!_expression.getValue().isTypeOf(Type.BOOLEAN)) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        return valid;
    }

    @Override
    public String toString() {
        return "!" + _expression;
    }
}
