package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.BinaryExpression;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.ValueUI;

public class Invalid extends Value {

    public Invalid() {
        super(Value.Type.INVALID);
    }

    @Override
    public boolean isInvalid() {
        return true;
    }

    @Override
    public Value calculateValueWith(final Expression right, final BinaryExpression expression) {
        return new Invalid();
    }

    @Override
    public Value calculateValueWith(final Bool left, final BinaryExpression expression) {
        return new Invalid();
    }

    @Override
    public Value calculateValueWith(final Money left, final BinaryExpression expression) {
        return new Invalid();
    }

    @Override
    public Value calculateValueWith(final Text left, final BinaryExpression expression) {
        return new Invalid();
    }

    @Override
    public ValueUI getLayout(final DeclarationUI parent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean applyValueTo(final Value type) {
        return false;
    }
}
