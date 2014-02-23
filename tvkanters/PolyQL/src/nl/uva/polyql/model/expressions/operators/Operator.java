package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operations.Operation;

public abstract class Operator<T> {

    public T performOperation(final Operation<T> operation) {
        final Object leftValue = operation.getLeft().getValue();
        final Object rightValue = operation.getRight().getValue();
        return performOperation(operation.getOperandType(), leftValue, rightValue);
    }

    protected abstract T performOperation(final Types operandType, final Object left, final Object right);

    public abstract String getSyntax();

    @Override
    public String toString() {
        return getSyntax();
    }
}
