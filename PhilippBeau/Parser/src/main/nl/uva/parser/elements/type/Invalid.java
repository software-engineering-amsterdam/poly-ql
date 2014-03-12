package main.nl.uva.parser.elements.type;

import java.awt.Component;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;

public class Invalid extends Value {

    public Invalid() {
        super(Value.Type.INVALID);
    }

    @Override
    public Expression getAtom() {
        return null;
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
    public Component getLayout() {
        return null;
    }

    @Override
    public boolean visitType(final Value type) {
        return false;
    }

}
