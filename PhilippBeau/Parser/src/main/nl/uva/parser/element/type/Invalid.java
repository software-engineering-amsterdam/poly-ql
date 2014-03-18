package main.nl.uva.parser.element.type;

import main.nl.uva.parser.element.expression.AdvancedExpression;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.ValueUI;

public class Invalid extends Value {

    public Invalid() {
        super(Value.Type.INVALID);
    }

    @Override
    public Expression getAtom() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInvalid() {
        return true;
    }

    @Override
    public Value visit(final Expression right, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Bool left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Money left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Text left, final AdvancedExpression expression) {
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
