package nl.uva.polyql.ast.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.operations.BinaryOperator;
import nl.uva.polyql.ast.expressions.operations.UnaryOperator;
import nl.uva.polyql.view.NumberValueView;
import nl.uva.polyql.view.QuestionView;

public class NumberValue extends Value<Double> {

    public NumberValue(final Double value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.NUMBER;
    }

    @Override
    public QuestionView getView(final Question question) {
        return new NumberValueView(question);
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

    /**
     * Parses the given user input as a number.
     * 
     * @param input
     *            The user input
     * 
     * @return The number value
     * 
     * @throws NumberFormatException
     *             Thrown when the input could not be parsed as a number
     */
    public static NumberValue parse(final String input) throws NumberFormatException {
        return new NumberValue(Double.parseDouble(input));
    }

}
