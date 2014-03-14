package nl.uva.polyql.ast.types;

public enum Type {
    BOOLEAN(new BooleanType()),
    NUMBER(new NumberType()),
    STRING(new StringType()),
    INVALID(new InvalidType());

    private final ValueType<?> mType;

    private Type(final ValueType<?> type) {
        mType = type;
    }

    public ValueType<?> getType() {
        return mType;
    }
}
