package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.OperationHelper;
import nl.uva.polyql.model.expressions.operators.Operator;

public abstract class SameOperandOperator<T> extends Operator<T> {

    @Override
    protected T performOperation(final Expression left, final Expression right) {
        return performOperation(OperationHelper.getOperandType(left, right), left.getValue(), right.getValue());
    }

    protected abstract T performOperation(final Type operandType, final Object leftValue, final Object rightValue);

    public boolean isValid(final Type leftType, final Type rightType) {
        return leftType == rightType && isValid(leftType);
    }

    public abstract boolean isValid(final Type type);
}
