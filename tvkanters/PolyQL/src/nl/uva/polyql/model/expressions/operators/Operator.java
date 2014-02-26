package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.Operation;
import nl.uva.polyql.model.values.Value;

public abstract class Operator<T extends Value<?>> {

    public T performOperation(final Operation<T> operation) {
        return performOperation(operation.getLeft(), operation.getRight());
    }

    protected abstract T performOperation(final Expression left, final Expression right);

    public abstract boolean isValid(final Type leftType, final Type rightType);

    public abstract String getSyntax();

    @Override
    public String toString() {
        return getSyntax();
    }
}
