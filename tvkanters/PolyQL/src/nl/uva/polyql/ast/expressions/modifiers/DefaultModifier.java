package nl.uva.polyql.ast.expressions.modifiers;

import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;

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
