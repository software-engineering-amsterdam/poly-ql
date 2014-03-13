package nl.uva.polyql.validation;

import nl.uva.polyql.ast.Field;
import nl.uva.polyql.model.types.Type;

public class InvalidTypeError extends ValidationError {
    private final Type mFieldType;
    private final Type mExpressionType;

    public InvalidTypeError(final Field field) {
        super(field);
        mFieldType = field.getType();
        mExpressionType = field.getExpression().getReturnType();
    }

    @Override
    public String getLabel() {
        return "Field type " + mFieldType + " does not match the expression type " + mExpressionType;
    }
}
