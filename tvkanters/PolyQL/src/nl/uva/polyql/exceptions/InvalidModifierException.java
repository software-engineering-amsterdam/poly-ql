package nl.uva.polyql.exceptions;

import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.types.Type;

public class InvalidModifierException extends ParsingException {

    private static final long serialVersionUID = -7593607078507836377L;

    private final Modifier<?> mModifier;
    private final Type mType;

    public InvalidModifierException(final Modifier<?> modifier, final Type type) {
        super("Invalid modifier " + modifier + " for type " + type);
        mModifier = modifier;
        mType = type;
    }

    public Modifier<?> getModifier() {
        return mModifier;
    }

    public Type getType() {
        return mType;
    }
}
