package nl.uva.polyql.ast.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.operations.BinaryOperator;
import nl.uva.polyql.ast.expressions.operations.UnaryOperator;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.view.QuestionView;
import nl.uva.polyql.view.StringValueView;

public class StringValue extends Value<String> {

    public StringValue(final String value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public QuestionView getView(final Question question) {
        return new StringValueView(question);
    }

    @Override
    public void setViewValue(final QuestionView view) {
        view.setComponentValue(this);
    }

    @Override
    public Value<?> performOperationOnLeft(final BinaryOperator operator, final Value<?> rightValue) {
        return rightValue.performOperationOnRight(this, operator);
    }

    @Override
    public Value<?> performOperationOnRight(final NumberValue leftValue, final BinaryOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public Value<?> performOperationOnRight(final StringValue leftValue, final BinaryOperator operator) {
        return operator.performOperation(leftValue, this);
    }

    @Override
    public Value<?> performUnaryOperation(final UnaryOperator operator) {
        return operator.performOperation(this);
    }

}
