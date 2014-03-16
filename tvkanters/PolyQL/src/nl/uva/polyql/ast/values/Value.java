package nl.uva.polyql.ast.values;

import java.util.Objects;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.modifiers.Modifier;
import nl.uva.polyql.ast.expressions.operations.Operator;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.view.QuestionView;

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

    public abstract QuestionView getView(Question question);

    public abstract void setViewValue(QuestionView view);

    public abstract Type getType();

    public Value<?> performOperationOnLeft(final Operator operator, final Value<?> rightValue) {
        return new InvalidValue();
    }

    public Value<?> performOperationOnRight(final BooleanValue leftValue, final Operator operator) {
        return new InvalidValue();
    }

    public Value<?> performOperationOnRight(final StringValue leftValue, final Operator operator) {
        return new InvalidValue();
    }

    public Value<?> performOperationOnRight(final NumberValue leftValue, final Operator operator) {
        return new InvalidValue();
    }

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
