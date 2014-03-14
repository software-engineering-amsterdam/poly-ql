package nl.uva.polyql.ast.expressions.modifiers;

import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.utils.SyntaxKey;

public abstract class Modifier<T extends Value<?>> implements SyntaxKey {

    private final String mSyntax;

    protected Modifier(final String syntax) {
        mSyntax = syntax;
    }

    @Override
    public String getSyntax() {
        return mSyntax;
    }

    /**
     * Checks if the modifier can be applied to values of the specified type.
     * 
     * @param type
     *            The type to check for
     * 
     * @return True iff the modifier is applicable
     */
    public abstract boolean isValid(final Type type);

    public abstract T apply(final T value);

    public abstract BooleanValue apply(final BooleanValue value);

    public abstract NumberValue apply(final NumberValue value);

    public abstract StringValue apply(final StringValue value);

    @Override
    public String toString() {
        return getSyntax();
    }
}
