package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class BooleanOperator extends SameOperandOperator<Boolean> {

    @Override
    protected Boolean performOperation(final Types operandType, final Object leftValue, final Object rightValue) {
        switch (operandType) {
        case BOOLEAN:
            return performOperation((boolean) leftValue, (boolean) rightValue);

        case NUMBER:
            return performOperation((double) leftValue, (double) rightValue);

        case STRING:
            return performOperation((String) leftValue, (String) rightValue);

        default:
            throw new UnsupportedOperandTypeException(operandType, getSyntax());
        }
    }

    protected abstract Boolean performOperation(final boolean left, final boolean right);

    protected abstract Boolean performOperation(final double left, final double right);

    protected abstract Boolean performOperation(final String left, final String right);

    @Override
    public boolean isValid(final Types type) {
        switch (type) {
        case BOOLEAN:
        case NUMBER:
        case STRING:
            return isValidForImplementedType(type);
        default:
            return false;
        }
    }

    public abstract boolean isValidForImplementedType(final Types type);
}
