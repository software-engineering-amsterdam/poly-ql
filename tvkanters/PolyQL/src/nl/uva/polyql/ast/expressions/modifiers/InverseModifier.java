package nl.uva.polyql.ast.expressions.modifiers;

import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;

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
        throw new RuntimeException();
    }

    @Override
    public StringValue apply(final StringValue value) {
        throw new RuntimeException();
    }
}
