package nl.uva.polyql.model.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operations.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.NumberValueView;
import nl.uva.polyql.view.ValueView;

public class NumberValue extends Value<Double> {

    public NumberValue(final Double value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.NUMBER;
    }

    @Override
    public ValueView getView(final Question question) {
        return new NumberValueView(question);
    }

    @Override
    public void setViewValue(final ValueView view) {
        view.setComponentValue(this);
    }

    @Override
    public Value<?> performOperationOnLeft(final Operator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public Value<?> performOperationOnRight(final NumberValue leftValue, final Operator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public Value<?> performOperationOnRight(final StringValue leftValue, final Operator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public NumberValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
