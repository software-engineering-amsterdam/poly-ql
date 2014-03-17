package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.OperationHelper;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

/**
 * An abstract operator that is useful for operator types that require the types of the left hand
 * and right hand expressions to be equals.
 * 
 * @param <T>
 *            The return type of the operator.
 */
public abstract class SameOperandOperator<T extends Value<?>> extends Operator<T> {

    @Override
    protected T performOperation(final Expression left, final Expression right) {
        return performOperation(OperationHelper.getOperandType(left, right), left.getValue(), right.getValue());
    }

    protected abstract T performOperation(final Type operandType, final Value<?> leftValue, final Value<?> rightValue);

    @Override
    public boolean isValid(final Type leftType, final Type rightType) {
        return leftType == rightType && isValid(leftType);
    }

    public abstract boolean isValid(final Type type);
}