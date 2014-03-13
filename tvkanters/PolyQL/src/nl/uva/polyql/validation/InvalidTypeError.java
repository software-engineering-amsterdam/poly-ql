package nl.uva.polyql.validation;

import nl.uva.polyql.model.types.Type;

public class InvalidTypeError extends ValidationError {
    private final Type mFieldType;
    private final Type mExpressionType;

    public InvalidTypeError(final Type fieldType, final Type expressionType) {
        mFieldType = fieldType;
        mExpressionType = expressionType;
    }

    @Override
    public String toString() {
        return "Field type " + mFieldType + " does not match the expression type " + mExpressionType;
    }
}
