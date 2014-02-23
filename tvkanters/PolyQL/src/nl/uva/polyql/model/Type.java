package nl.uva.polyql.model;

public enum Type {
    BOOLEAN(false),
    NUMBER(0.0),
    STRING("");

    public static final String BOOLEAN_TRUE = "true";
    public static final String BOOLEAN_FALSE = "false";

    private final Object mDefaultValue;

    private Type(final Object defaultValue) {
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
    public Object parseInput(final String input) {
        switch (this) {
        case BOOLEAN:
            if (input.equals(BOOLEAN_TRUE)) {
                return true;
            }
            if (input.equals(BOOLEAN_FALSE)) {
                return false;
            }
            return null;

        case NUMBER:
            try {
                return Double.parseDouble(input);
            } catch (final NumberFormatException ex) {
                return null;
            }

        case STRING:
            return input.substring(1, input.length() - 1);

        default:
            throw new RuntimeException("Unsupported type");
        }
    }

    public Object getDefaultValue() {
        return mDefaultValue;
    }
}
