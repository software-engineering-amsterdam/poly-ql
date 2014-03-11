package main.nl.uva.parser.elements.type;

import java.awt.Component;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;

public class Invalid extends Type {

    public Invalid() {
        super(Type.Of.INVALID);
    }

    @Override
    public Expression getAtom() {
        return null;
    }

    @Override
    public Type visit(final Expression right, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Type accept(final Bool left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Type accept(final Money left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Type accept(final Text left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Component getLayout() {
        return null;
    }

}
