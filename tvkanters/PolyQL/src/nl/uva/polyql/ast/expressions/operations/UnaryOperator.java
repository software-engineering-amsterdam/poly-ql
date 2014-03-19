package nl.uva.polyql.ast.expressions.operations;

import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.InvalidValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.utils.SyntaxKey;

public abstract class UnaryOperator implements SyntaxKey {

    public Value<?> performOperation(final UnaryOperation operation) {
        return operation.getExpression().getValue().performUnaryOperation(this);
    }

    public Value<?> performOperation(final BooleanValue value) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final NumberValue value) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final StringValue value) {
        return new InvalidValue();
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
