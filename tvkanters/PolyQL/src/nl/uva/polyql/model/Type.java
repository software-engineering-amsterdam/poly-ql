package nl.uva.polyql.model;

import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public enum Type {
    BOOLEAN(new BooleanValue(false)),
    NUMBER(new NumberValue(0.0)),
    STRING(new StringValue(""));

    public static final String BOOLEAN_TRUE = "true";
    public static final String BOOLEAN_FALSE = "false";

    private final Value<?> mDefaultValue;

    private Type(final Value<?> defaultValue) {
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the type specific value corresponding to the user's string input.
     * 
     * @param input
     *            The string that the user entered
     * 
     * @return The type specific value or null if it couldn't be parsed
     */
    public Value<?> parseInput(final String input) {
        switch (this) {
        case BOOLEAN:
            if (input.equals(BOOLEAN_TRUE)) {
                return new BooleanValue(true);
            }
            if (input.equals(BOOLEAN_FALSE)) {
                return new BooleanValue(false);
            }
            return null;

        case NUMBER:
            try {
                return new NumberValue(Double.parseDouble(input));
            } catch (final NumberFormatException ex) {
                return null;
            }

        case STRING:
            return new StringValue(input.substring(1, input.length() - 1));

        default:
            throw new RuntimeException("Unsupported type");
        }
    }

    public Value<?> getDefaultValue() {
        return mDefaultValue;
    }
}
