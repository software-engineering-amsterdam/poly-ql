package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class NumberOperator extends SameOperandOperator<Double> {

    @Override
    protected Double performOperation(final Types operandType, final Object leftValue, final Object rightValue) {
        switch (operandType) {
        case NUMBER:
            return performOperation((double) leftValue, (double) rightValue);

        default:
            throw new UnsupportedOperandTypeException(operandType, getSyntax());
        }
    }

    protected abstract Double performOperation(final double left, final double right);

    @Override
    public boolean isValid(final Types type) {
        return type == Types.NUMBER;
    }
}
