package nl.uva.polyql.model.expressions.modifiers;

import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;
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

    public abstract boolean isValid(final Type type);

    public abstract T apply(final T value);

    public abstract BooleanValue apply(final BooleanValue value);

    public abstract NumberValue apply(final NumberValue value);

    public abstract StringValue apply(final StringValue value);
}
