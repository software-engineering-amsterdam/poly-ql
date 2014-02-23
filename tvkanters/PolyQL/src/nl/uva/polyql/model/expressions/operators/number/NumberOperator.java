package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class NumberOperator extends Operator<Double> {

    @Override
    protected Double performOperation(final Types operandType, final Object left, final Object right) {
        switch (operandType) {
        case NUMBER:
            return performOperation((double) left, (double) right);

        default:
            throw new UnsupportedOperandTypeException(operandType);
        }
    }

    protected abstract Double performOperation(final double left, final double right);
}
