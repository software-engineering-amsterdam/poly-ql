package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.OperationHelper;
import nl.uva.polyql.model.expressions.operators.Operator;

public abstract class SameOperandOperator<T> extends Operator<T> {

    @Override
    protected T performOperation(final Expression left, final Expression right) {
        return performOperation(OperationHelper.getOperandType(left, right), left.getValue(), right.getValue());
    }

    protected abstract T performOperation(final Types operandType, final Object leftValue, final Object rightValue);

    public boolean isValid(final Types leftType, final Types rightType) {
        return leftType == rightType && isValid(leftType);
    }

    public abstract boolean isValid(final Types type);
}
