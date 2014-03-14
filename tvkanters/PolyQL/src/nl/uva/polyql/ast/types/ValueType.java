package nl.uva.polyql.ast.types;

import nl.uva.polyql.ast.values.Value;

public abstract class ValueType<T extends Value<?>> {

    private final T mDefaultValue;

    protected ValueType(final T defaultValue) {
        mDefaultValue = defaultValue;
    }

    public Value<?> getDefaultValue() {
        return mDefaultValue;
    }

    /**
     * Parses the user input as value of the object's type.
     * 
     * @param input
     *            The input to parse
     * 
     * @return The input's value representation or null if it couldn't be parsed
     */
    public abstract T parseInput(final String input);
}
