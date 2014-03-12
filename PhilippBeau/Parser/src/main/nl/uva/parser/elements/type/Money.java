package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;

public class Money extends Type {

    public Money() {
        super(Type.Of.MONEY);
    }

    @Override
    public Expression getAtom() {
        return new MoneyAtom();
    }

    @Override
    public Type visit(final Expression right, final AdvancedExpression expression) {
        return right.getType().accept(this, expression);
    }

    @Override
    public Type accept(final Bool left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Type accept(final Money left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Type accept(final Text left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }
}
