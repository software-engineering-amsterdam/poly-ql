package nl.uva.polyql.model.values;

import nl.uva.polyql.exceptions.UnsupportedOperandTypeException;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operators.bool.BooleanOperator;
import nl.uva.polyql.model.expressions.operators.number.NumberOperator;
import nl.uva.polyql.model.expressions.operators.string.StringOperator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.StringValueView;
import nl.uva.polyql.view.ValueView;

public class StringValue extends Value<String> {

    private static final Type TYPE = Type.STRING;

    public StringValue(final String value) {
        super(value);
    }

    @Override
    public Type getType() {
        return TYPE;
    }

    @Override
    public ValueView getView(final Question question) {
        return new StringValueView(question);
    }

    @Override
    public void setViewValue(final ValueView view) {
        view.setComponentValue(this);
    }

    @Override
    public BooleanValue performOperationOnLeft(final BooleanOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public NumberValue performOperationOnLeft(final NumberOperator operator, final Value<?> rightValue) {
        throw new UnsupportedOperandTypeException(this, operator, rightValue);
    }

    @Override
    public StringValue performOperationOnLeft(final StringOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public BooleanValue performOperationOnRight(final BooleanValue leftValue, final BooleanOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public BooleanValue performOperationOnRight(final NumberValue leftValue, final BooleanOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public BooleanValue performOperationOnRight(final StringValue leftValue, final BooleanOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public NumberValue performOperationOnRight(final NumberValue leftValue, final NumberOperator operator) {
        throw new UnsupportedOperandTypeException(leftValue, operator, this);
    }

    @Override
    public StringValue performOperationOnRight(final NumberValue leftValue, final StringOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public StringValue performOperationOnRight(final StringValue leftValue, final StringOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public StringValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
