package nl.uva.polyql.model.values;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.StringValueView;
import nl.uva.polyql.view.ValueView;

public class StringValue extends Value<String> {

    public StringValue(final String value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.STRING;
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
    public StringValue applyModifier(final Modifier<?> modifier) {
        return modifier.apply(this);
    }

}
