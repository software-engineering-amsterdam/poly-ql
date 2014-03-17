package nl.uva.polyql.model.expressions.modifiers;

import nl.uva.polyql.exceptions.InvalidModifierException;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class InverseModifier extends Modifier<BooleanValue> {

    private static final String SYNTAX = "!";

    public InverseModifier() {
        super(SYNTAX);
    }

    @Override
    public boolean isValid(final Type type) {
        return type == Type.BOOLEAN;
    }

    @Override
    public BooleanValue apply(final BooleanValue value) {
        return new BooleanValue(!value.getValue());
    }

    @Override
    public NumberValue apply(final NumberValue value) {
        throw new InvalidModifierException(this, value.getType());
    }

    @Override
    public StringValue apply(final StringValue value) {
        throw new InvalidModifierException(this, value.getType());
    }
}