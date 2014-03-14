package nl.uva.polyql.ast.types;

import nl.uva.polyql.ast.values.BooleanValue;

public class BooleanType extends ValueType<BooleanValue> {

    private static final BooleanValue DEFAULT_VALUE = new BooleanValue(false);

    public BooleanType() {
        super(DEFAULT_VALUE);
    }

    @Override
    public BooleanValue parseInput(final String input) {
        return new BooleanValue(Boolean.parseBoolean(input));
    }
}
