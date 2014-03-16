package nl.uva.polyql.ast.values;


public enum Type {
    BOOLEAN(new BooleanValue(false)),
    NUMBER(new NumberValue(0.0)),
    STRING(new StringValue("")),
    INVALID(new InvalidValue());

    private final Value<?> mDefaultValue;

    private Type(final Value<?> defaultValue) {
        mDefaultValue = defaultValue;
    }

    public Value<?> getDefaultValue() {
        return mDefaultValue;
    }
}
