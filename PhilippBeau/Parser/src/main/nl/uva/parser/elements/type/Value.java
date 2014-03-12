package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;
import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.ui.DeclarationUIElement;
import main.nl.uva.parser.elements.ui.types.ValueUI;

public abstract class Value {

    public enum Type {
        MONEY,
        BOOLEAN,
        TEXT,
        INVALID;

        public static Expression getAtomFor(final Value.Type type) {
            switch (type) {
            case MONEY:
                return new MoneyAtom();

            case BOOLEAN:
                return new BoolAtom();

            case TEXT:
                return new TextAtom();

            default:
                return null;
            }
        }

        public Value getTypeObject() {
            switch (this) {
            case MONEY:
                return new Money();

            case BOOLEAN:
                return new Bool();

            case TEXT:
                return new Text();

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

    public abstract Expression getAtom();

    public abstract Value visit(Expression right, AdvancedExpression expression);

    public abstract Value accept(Bool left, AdvancedExpression expression);

    public abstract Value accept(Money left, AdvancedExpression expression);

    public abstract Value accept(Text left, AdvancedExpression expression);

    public abstract ValueUI getLayout(DeclarationUIElement parent);

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
