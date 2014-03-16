package nl.uva.polyql.ast.types;

import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.InvalidValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;

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
