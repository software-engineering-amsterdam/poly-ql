package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;

public class OperationHelper {

    public static Operation<?> getSameTypeOperation(final Expression left, final String operator,
            final Expression right) {
        final Types type = getOperandType(left, right);
        switch (type) {
        case BOOLEAN:
            return new BooleanOperation(left, operator, right);
        case NUMBER:
            return new NumberOperation(left, operator, right);
        case STRING:
            return new StringOperation(left, operator, right);
        default:
            throw new RuntimeException("Invalid operand type " + type);
        }
    }

    public static Types getOperandType(final Expression left, final Expression right) {
        final Types leftType = left.getReturnType();
        final Types rightType = right.getReturnType();
        if (leftType != rightType) {
            throw new RuntimeException("Operand types " + leftType + " and " + rightType + " are not equal");
        }

        return leftType;
    }
}
