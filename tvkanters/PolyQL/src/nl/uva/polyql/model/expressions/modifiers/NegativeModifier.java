package nl.uva.polyql.model.expressions.modifiers;

import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class NegativeModifier extends Modifier<NumberValue> {

    private static final String SYNTAX = "-";

    public NegativeModifier() {
        super(SYNTAX);
    }

    @Override
    public boolean isValid(final Type type) {
        return type == Type.NUMBER;
    }

    @Override
    public NumberValue apply(final NumberValue value) {
        return new NumberValue(-value.getValue());
    }

    @Override
    public BooleanValue apply(final BooleanValue value) {
        // TODO throw exception
        return null;
    }

    @Override
    public StringValue apply(final StringValue value) {
        // TODO throw exception
        return null;
    }
}
