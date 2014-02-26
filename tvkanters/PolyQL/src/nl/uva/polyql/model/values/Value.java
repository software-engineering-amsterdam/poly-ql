package nl.uva.polyql.model.values;

import nl.uva.polyql.model.expressions.operators.bool.BooleanOperator;
import nl.uva.polyql.model.expressions.operators.number.NumberOperator;
import nl.uva.polyql.model.expressions.operators.string.StringOperator;

public abstract class Value<T> {

    private final T mValue;

    public Value(final T value) {
        mValue = value;
    }

    public T getValue() {
        return mValue;
    }

    public abstract BooleanValue performOperationOnLeft(final BooleanOperator operator, final Value<?> rightValue);

    public abstract NumberValue performOperationOnLeft(final NumberOperator operator, final Value<?> rightValue);

    public abstract StringValue performOperationOnLeft(final StringOperator operator, final Value<?> rightValue);

    public abstract BooleanValue performOperationOnRight(final BooleanValue leftValue, final BooleanOperator operator);

    public abstract BooleanValue performOperationOnRight(final NumberValue leftValue, final BooleanOperator operator);

    public abstract BooleanValue performOperationOnRight(final StringValue leftValue, final BooleanOperator operator);

    public abstract NumberValue performOperationOnRight(final NumberValue leftValue, final NumberOperator operator);

    public abstract StringValue performOperationOnRight(final StringValue leftValue, final StringOperator operator);

    public abstract StringValue performOperationOnRight(final NumberValue leftValue, final StringOperator operator);

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Value<?>)) {
            return false;
        }

        final Value<?> other = (Value<?>) obj;
        if (mValue == null) {
            return other.mValue == null;
        }

        return mValue.equals(mValue);
    }

    @Override
    public String toString() {
        return mValue.toString();
    }
}
