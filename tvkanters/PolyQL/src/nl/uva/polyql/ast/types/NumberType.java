package nl.uva.polyql.ast.types;

import nl.uva.polyql.ast.values.NumberValue;

public class NumberType extends ValueType<NumberValue> {

    private static final NumberValue DEFAULT_VALUE = new NumberValue(0.0);

    public NumberType() {
        super(DEFAULT_VALUE);
    }

    @Override
    public NumberValue parseInput(final String input) {
        try {
            return new NumberValue(Double.parseDouble(input));
        } catch (final NumberFormatException ex) {
            return null;
        }
    }
}
