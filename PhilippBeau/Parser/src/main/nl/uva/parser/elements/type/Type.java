package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;
import main.nl.uva.parser.elements.statements.Statement;

public abstract class Type {

    public enum Of {
        MONEY,
        BOOLEAN,
        TEXT;

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
}
