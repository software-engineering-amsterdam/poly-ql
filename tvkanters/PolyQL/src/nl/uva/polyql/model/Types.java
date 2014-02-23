package nl.uva.polyql.model;

public enum Types {
    BOOLEAN(false),
    NUMBER(0.0),
    STRING("bob");

    public static final String BOOLEAN_TRUE = "1";

    private final Object mDefaultValue;

    private Types(final Object defaultValue) {
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
            return input.equals(BOOLEAN_TRUE);
        case NUMBER:
            try {
                return Double.parseDouble(input);
            } catch (final NumberFormatException ex) {
                return null;
            }
        case STRING:
            return input;
        default:
            throw new RuntimeException("Unsupported type");
        }
    }

    public Object getDefaultValue() {
        return mDefaultValue;
    }
}
