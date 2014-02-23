package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public class OperationHelper {

    public static Operation<?> getOperation(final Expression left, final String operator, final Expression right) {

        final Types leftType = left.getReturnType();
        final Types rightType = right.getReturnType();

        if (BooleanOperation.isValid(leftType, operator, rightType)) {
            return new BooleanOperation(left, operator, right);
        }
        if (NumberOperation.isValid(leftType, operator, rightType)) {
            return new NumberOperation(left, operator, right);
        }
        if (StringOperation.isValid(leftType, operator, rightType)) {
            return new StringOperation(left, operator, right);
        }

        throw new UnsupportedOperandTypeException(leftType, operator, rightType);
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
