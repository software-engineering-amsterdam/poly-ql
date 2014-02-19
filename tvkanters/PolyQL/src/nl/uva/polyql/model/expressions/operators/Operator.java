package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.Operation;

public abstract class Operator<T> {

    public T performOperation(final Operation<T> operation) {
        final Expression left = operation.getLeft();
        final Expression right = operation.getRight();

        switch (operation.getOperandType()) {
        case BOOLEAN:
            return performOperation(left.getBooleanValue(), right.getBooleanValue());

        case NUMBER:
            return performOperation(left.getNumberValue(), right.getNumberValue());

        default:
            throw new RuntimeException("Unsupported operand type " + operation.getOperandType());
        }
    }

    protected abstract T performOperation(final boolean left, final boolean right);

    protected abstract T performOperation(final double left, final double right);

    public abstract String getSyntax();
    
    @Override
    public String toString() {
        return getSyntax();
    }
}
