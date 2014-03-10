package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;

public class Bool extends Type {

    public Bool() {
        super(Type.Of.BOOLEAN);
    }

    @Override
    public Expression getAtom() {
        return new BoolAtom();
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
