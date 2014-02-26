package nl.uva.polyql.model.expressions;

import java.util.HashMap;
import java.util.Map;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.Value;

public enum Modifier {
    NONE(""),
    NEGATIVE("-"),
    INVERSE("!");

    private static final Map<String, Modifier> sSyntaxMap = new HashMap<>();

    static {
        for (final Modifier modifier : values()) {
            sSyntaxMap.put(modifier.getSyntax(), modifier);
        }
    }

    public static Modifier getBySyntax(final String syntax) {
        if (syntax == null) {
            return NONE;
        }
        return sSyntaxMap.get(syntax);
    }

    private final String mSyntax;

    private Modifier(final String syntax) {
        mSyntax = syntax;
    }

    public Value<?> apply(final Question question) {
        final Type type = question.getType();
        final Value<?> value = question.getValue();

        switch (this) {
        case NONE:
            return value;

        case INVERSE:
            if (type == Type.BOOLEAN) {
                return new BooleanValue(!((BooleanValue) value).getValue());
            }
            break;

        case NEGATIVE:
            if (type == Type.NUMBER) {
                return new NumberValue(-((NumberValue) value).getValue());
            }
            break;

        default:
            // Other types don't have modifiers
        }

        throw new RuntimeException("Unsupported modifier " + this + " for type " + type);
    }

    public boolean isValid(final Type type) {
        switch (this) {
        case NONE:
            return true;

        case INVERSE:
            return type == Type.BOOLEAN;

        case NEGATIVE:
            return type == Type.NUMBER;

        default:
            return false;
        }
    }

    public String getSyntax() {
        return mSyntax;
    }
}
