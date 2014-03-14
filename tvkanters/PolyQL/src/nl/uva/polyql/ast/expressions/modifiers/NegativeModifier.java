package nl.uva.polyql.ast.expressions.modifiers;

import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;

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
        throw new RuntimeException();
    }

    @Override
    public StringValue apply(final StringValue value) {
        throw new RuntimeException();
    }
}
