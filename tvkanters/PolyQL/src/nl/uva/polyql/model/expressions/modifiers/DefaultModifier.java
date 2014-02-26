package nl.uva.polyql.model.expressions.modifiers;

import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public class DefaultModifier extends Modifier<Value<?>> {

    private static final String SYNTAX = "";

    public DefaultModifier() {
        super(SYNTAX);
    }

    @Override
    public boolean isValid(final Type type) {
        return true;
    }

    @Override
    public Value<?> apply(final Value<?> value) {
        return value.applyModifier(this);
    }

    @Override
    public BooleanValue apply(final BooleanValue value) {
        return value;
    }

    @Override
    public NumberValue apply(final NumberValue value) {
        return value;
    }

    @Override
    public StringValue apply(final StringValue value) {
        return value;
    }
}
