package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;
import main.nl.uva.parser.elements.statements.Statement;

public abstract class Type {

    public enum Of {
        MONEY,
        BOOLEAN,
        TEXT,
        INVALID;

        public static Expression getAtomFor(final Type.Of type) {
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

        public Type getTypeObject() {
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

    private final Type.Of _typeOf;

    public Type(final Type.Of typeOf) {
        _typeOf = typeOf;
    }

    @Override
    public String toString() {
        return _typeOf.toString();
    }

    public abstract Expression getAtom();

    public abstract Type visit(Expression right, AdvancedExpression expression);

    public abstract Type accept(Bool left, AdvancedExpression expression);

    public abstract Type accept(Money left, AdvancedExpression expression);

    public abstract Type accept(Text left, AdvancedExpression expression);

}
