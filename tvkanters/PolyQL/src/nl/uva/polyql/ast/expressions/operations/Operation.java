package nl.uva.polyql.ast.expressions.operations;

import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.Value;

public abstract class Operation extends Expression {

    private Value<?> mValue;

    protected void setValue(final Value<?> value) {
        mValue = value;
    }

    @Override
    public Value<?> getValue() {
        return mValue;
    }

    @Override
    public Type getReturnType() {
        return mValue.getType();
    }

    @Override
    public boolean isValid() {
        return mValue.getType() != Type.INVALID;
    }
}
