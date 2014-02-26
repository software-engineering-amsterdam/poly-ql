package nl.uva.polyql.model.types;

import nl.uva.polyql.model.values.StringValue;

public class StringType extends ValueType<StringValue> {

    private static final StringValue DEFAULT_VALUE = new StringValue("");

    public StringType() {
        super(DEFAULT_VALUE);
    }

    @Override
    public StringValue parseInput(final String input) {
        return new StringValue(parseInputToString(input));
    }

    public static String parseInputToString(final String input) {
        return input.substring(1, input.length() - 1);
    }
}
