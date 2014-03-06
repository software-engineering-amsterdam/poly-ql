package nl.uva.polyql.model.values;

import nl.uva.polyql.exceptions.UnsupportedOperandTypeException;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operators.bool.BooleanOperator;
import nl.uva.polyql.model.expressions.operators.number.NumberOperator;
import nl.uva.polyql.model.expressions.operators.string.StringOperator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.NumberValueView;
import nl.uva.polyql.view.ValueView;

public class NumberValue extends Value<Double> {

    private static final Type TYPE = Type.NUMBER;

    public NumberValue(final Double value) {
        super(value);
    }

    @Override
    public Type getType() {
        return TYPE;
    }

    @Override
    public ValueView<?> getView(final Question question) {
        return new NumberValueView(question);
    }

    @Override
    public void setViewValue(final ValueView<?> view) {
        view.setComponentValue(this);
    }

    @Override
    public BooleanValue performOperationOnLeft(final BooleanOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public NumberValue performOperationOnLeft(final NumberOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public StringValue performOperationOnLeft(final StringOperator operator, final Value<?> rightValue) {
        throw new UnsupportedOperandTypeException(this, operator, rightValue);
    }

    @Override
    public BooleanValue performOperationOnRight(final BooleanValue leftValue, final BooleanOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public BooleanValue performOperationOnRight(final NumberValue leftValue, final BooleanOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public BooleanValue performOperationOnRight(final StringValue leftValue, final BooleanOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public NumberValue performOperationOnRight(final NumberValue leftValue, final NumberOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public StringValue performOperationOnRight(final StringValue leftValue, final StringOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public StringValue performOperationOnRight(final NumberValue leftValue, final StringOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public NumberValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
