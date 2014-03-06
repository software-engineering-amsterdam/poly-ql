package nl.uva.polyql.model.values;

import java.util.Objects;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operators.bool.BooleanOperator;
import nl.uva.polyql.model.expressions.operators.number.NumberOperator;
import nl.uva.polyql.model.expressions.operators.string.StringOperator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.ValueView;

/**
 * A value representation heavily utilising the visitor pattern to perform operations on different
 * types and to apply modifiers.
 * 
 * @param <T>
 *            The type of the literal value
 */
public abstract class Value<T> {

    private final T mValue;

    public Value(final T value) {
        mValue = value;
    }

    public T getValue() {
        return mValue;
    }

    public abstract ValueView<?> getView(Question question);

    public abstract void setViewValue(ValueView<?> view);

    public abstract Type getType();

    public abstract BooleanValue performOperationOnLeft(BooleanOperator operator, Value<?> rightValue);

    public abstract NumberValue performOperationOnLeft(NumberOperator operator, Value<?> rightValue);

    public abstract StringValue performOperationOnLeft(StringOperator operator, Value<?> rightValue);

    public abstract BooleanValue performOperationOnRight(BooleanValue leftValue, BooleanOperator operator);

    public abstract BooleanValue performOperationOnRight(NumberValue leftValue, BooleanOperator operator);

    public abstract BooleanValue performOperationOnRight(StringValue leftValue, BooleanOperator operator);

    public abstract NumberValue performOperationOnRight(NumberValue leftValue, NumberOperator operator);

    public abstract StringValue performOperationOnRight(StringValue leftValue, StringOperator operator);

    public abstract StringValue performOperationOnRight(NumberValue leftValue, StringOperator operator);

    public abstract Value<T> applyModifier(Modifier<?> modifier);

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Value<?>)) {
            return false;
        }

        return Objects.equals(mValue, ((Value<?>) obj).mValue);
    }

    @Override
    public String toString() {
        return mValue.toString();
    }
}
