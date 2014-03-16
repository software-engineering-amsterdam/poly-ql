package nl.uva.polyql.ast.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.modifiers.Modifier;
import nl.uva.polyql.ast.expressions.operations.Operator;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.view.BooleanValueView;
import nl.uva.polyql.view.QuestionView;

public class BooleanValue extends Value<Boolean> {

    public BooleanValue(final Boolean value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.BOOLEAN;
    }

    @Override
    public QuestionView getView(final Question question) {
        return new BooleanValueView(question);
    }

    @Override
    public void setViewValue(final QuestionView view) {
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
