package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.expressions.operators.Operator;

public abstract class NumberOperator extends Operator<Double> {

    @Override
    protected Double performOperation(final Object left, final Object right) {
        if (left instanceof Double) {
            return performOperation((double) left, (double) right);
        }

        throw new RuntimeException("Invalid operand value " + left.getClass().getName());
    }

    protected abstract Double performOperation(final double left, final double right);
}
