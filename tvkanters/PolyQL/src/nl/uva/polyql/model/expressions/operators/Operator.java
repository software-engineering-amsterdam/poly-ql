package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.Operation;

public abstract class Operator<T> {

    public T performOperation(final Operation<T> operation) {
        return performOperation(operation.getLeft().getValue(), operation.getRight().getValue());
    }

    protected abstract T performOperation(final Object left, final Object right);

    public abstract String getSyntax();

    @Override
    public String toString() {
        return getSyntax();
    }
}
