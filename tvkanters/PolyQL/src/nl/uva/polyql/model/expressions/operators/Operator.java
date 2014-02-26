package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.Operation;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;
import nl.uva.polyql.utils.SyntaxKey;

public abstract class Operator<T extends Value<?>> implements SyntaxKey {

    public T performOperation(final Operation<T> operation) {
        return performOperation(operation.getLeft(), operation.getRight());
    }

    protected abstract T performOperation(final Expression left, final Expression right);

    public abstract boolean isValid(final Type leftType, final Type rightType);

    @Override
    public abstract String getSyntax();

    @Override
    public String toString() {
        return getSyntax();
    }
}
