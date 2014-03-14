package nl.uva.polyql.ast.expressions.operations;

import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.InvalidValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.utils.SyntaxKey;

public abstract class Operator implements SyntaxKey {

    public Value<?> performOperation(final Operation operation) {
        return operation.getLeft().getValue().performOperationOnLeft(this, operation.getRight().getValue());
    }

    public Value<?> performOperation(final BooleanValue leftValue, final BooleanValue booleanValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final NumberValue leftValue, final NumberValue numberValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final StringValue leftValue, final NumberValue numberValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final NumberValue leftValue, final StringValue stringValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final StringValue leftValue, final StringValue stringValue) {
        return new InvalidValue();
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
