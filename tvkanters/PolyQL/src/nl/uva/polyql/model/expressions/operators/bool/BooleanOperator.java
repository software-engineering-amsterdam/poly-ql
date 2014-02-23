package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class BooleanOperator extends Operator<Boolean> {

    @Override
    protected Boolean performOperation(final Types operandType, final Object left, final Object right) {
        switch (operandType) {
        case BOOLEAN:
            return performOperation((boolean) left, (boolean) right);

        case NUMBER:
            return performOperation((double) left, (double) right);

        case STRING:
            return performOperation((String) left, (String) right);

        default:
            throw new UnsupportedOperandTypeException(operandType);
        }
    }

    protected abstract Boolean performOperation(final boolean left, final boolean right);

    protected abstract Boolean performOperation(final double left, final double right);

    protected abstract Boolean performOperation(final String left, final String right);
}
