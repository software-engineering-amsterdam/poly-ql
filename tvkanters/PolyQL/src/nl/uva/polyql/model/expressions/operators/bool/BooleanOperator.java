package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.expressions.operators.Operator;

public abstract class BooleanOperator extends Operator<Boolean> {

    @Override
    protected Boolean performOperation(final Object left, final Object right) {
        if (left instanceof Boolean) {
            return performOperation((boolean) left, (boolean) right);
        }
        if (left instanceof Double) {
            return performOperation((double) left, (double) right);
        }

        throw new RuntimeException("Invalid operand value " + left.getClass().getName());
    }

    protected abstract Boolean performOperation(final boolean left, final boolean right);

    protected abstract Boolean performOperation(final double left, final double right);
}
