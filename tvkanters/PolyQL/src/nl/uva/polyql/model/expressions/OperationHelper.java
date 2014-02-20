package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;

public class OperationHelper {

    public static Operation<?> getOperationForOperands(final Expression left, final String operator,
            final Expression right) {
        final Type type = getOperandType(left, right);
        switch (type) {
        case BOOLEAN:
            return new BooleanOperation(left, operator, right);
        case NUMBER:
            return new NumberOperation(left, operator, right);
        default:
            throw new RuntimeException("Invalid operand type " + type);
        }
    }

    public static Type getOperandType(final Expression left, final Expression right) {
        final Type leftType = left.getReturnType();
        final Type rightType = right.getReturnType();
        if (leftType != rightType) {
            throw new RuntimeException("Operand types " + leftType + " and " + rightType + " are not equal");
        }

        return leftType;
    }
}
