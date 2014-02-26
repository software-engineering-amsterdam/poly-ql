package nl.uva.polyql.model.values;

import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operators.bool.BooleanOperator;
import nl.uva.polyql.model.expressions.operators.number.NumberOperator;
import nl.uva.polyql.model.expressions.operators.string.StringOperator;

public class BooleanValue extends Value<Boolean> {

    public BooleanValue(final Boolean value) {
        super(value);
    }

    @Override
    public BooleanValue performOperationOnLeft(final BooleanOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public NumberValue performOperationOnLeft(final NumberOperator operator, final Value<?> rightValue) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public StringValue performOperationOnLeft(final StringOperator operator, final Value<?> rightValue) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public BooleanValue performOperationOnRight(final BooleanValue leftValue, final BooleanOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public BooleanValue performOperationOnRight(final NumberValue leftValue, final BooleanOperator operator) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public BooleanValue performOperationOnRight(final StringValue leftValue, final BooleanOperator operator) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public NumberValue performOperationOnRight(final NumberValue leftValue, final NumberOperator operator) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public StringValue performOperationOnRight(final StringValue leftValue, final StringOperator operator) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public StringValue performOperationOnRight(final NumberValue leftValue, final StringOperator operator) {
        // TODO: Throw exception
        return null;
    }

    @Override
    public BooleanValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
