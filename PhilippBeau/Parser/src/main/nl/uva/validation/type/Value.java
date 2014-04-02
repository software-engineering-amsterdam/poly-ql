package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.BinaryExpression;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.parser.expression.unary.UnaryExpression;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.ValueUI;

public abstract class Value {

    public enum Type {
        MONEY,
        BOOLEAN,
        TEXT,
        INVALID;

        public Expression getAtom() {
            switch (this) {
            case MONEY:
                return new UnaryExpression(new Money());

            case BOOLEAN:
                return new UnaryExpression(new Bool());

            case TEXT:
                return new UnaryExpression(new Text());

            default:
                return null;
            }
        }
    }

    protected Statement _expression = null;

    private final Value.Type _typeOf;

    public Value(final Value.Type typeOf) {
        _typeOf = typeOf;
    }

    @Override
    public String toString() {
        return _typeOf.toString();
    }

    public boolean isTypeOf(final Type type) {
        return _typeOf.equals(type);
    }

    public boolean isOfSameType(final Value other) {
        return _typeOf.equals(other._typeOf);
    }

    public abstract Value calculateValueWith(Expression right, BinaryExpression expression);

    public abstract Value calculateValueWith(Bool left, BinaryExpression expression);

    public abstract Value calculateValueWith(Money left, BinaryExpression expression);

    public abstract Value calculateValueWith(Text left, BinaryExpression expression);

    public abstract ValueUI getLayout(DeclarationUI parent);

    public boolean isInvalid() {
        return false;
    }

    public abstract boolean applyValueTo(Value type);

    public boolean acceptType(final Bool type) {
        return false;
    }

    public boolean acceptType(final Money type) {
        return false;
    }

    public boolean acceptType(final Text type) {
        return false;
    }
}
