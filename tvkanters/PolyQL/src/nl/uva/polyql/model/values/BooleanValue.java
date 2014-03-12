package nl.uva.polyql.model.values;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operations.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.BooleanValueView;
import nl.uva.polyql.view.ValueView;

public class BooleanValue extends Value<Boolean> {

    public BooleanValue(final Boolean value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.BOOLEAN;
    }

    @Override
    public ValueView getView(final Question question) {
        return new BooleanValueView(question);
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
    public Value<?> performOperationOnRight(final BooleanValue leftValue, final Operator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public BooleanValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
