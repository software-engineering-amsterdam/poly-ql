package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.AdvancedExpression;
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
    public Value applyTo(final Expression right, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value applyTo(final Bool left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value applyTo(final Money left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value applyTo(final Text left, final AdvancedExpression expression) {
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
