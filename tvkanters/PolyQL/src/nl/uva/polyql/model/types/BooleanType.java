package nl.uva.polyql.model.types;

import nl.uva.polyql.model.values.BooleanValue;

public class BooleanType extends ValueType<BooleanValue> {

    private static final BooleanValue DEFAULT_VALUE = new BooleanValue(false);
    public static final String BOOLEAN_TRUE = "true";
    public static final String BOOLEAN_FALSE = "false";

    public BooleanType() {
        super(DEFAULT_VALUE);
    }

    @Override
    public BooleanValue parseInput(final String input) {
        if (input.equals(BOOLEAN_TRUE)) {
            return new BooleanValue(true);
        }
        if (input.equals(BOOLEAN_FALSE)) {
            return new BooleanValue(false);
        }

        return null;
    }
}
