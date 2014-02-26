package nl.uva.polyql.model.types;

import nl.uva.polyql.model.values.Value;

public abstract class ValueType<T extends Value<?>> {

    private final T mDefaultValue;

    protected ValueType(final T defaultValue) {
        mDefaultValue = defaultValue;
    }

    public Value<?> getDefaultValue() {
        return mDefaultValue;
    }

    public abstract T parseInput(final String input);
}
