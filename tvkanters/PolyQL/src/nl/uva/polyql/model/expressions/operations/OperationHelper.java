package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.types.Type;

public class OperationHelper {

    /**
     * Retrieves the operand type of the left and right expression, given that they're the same.
     * 
     * @param left
     *            The left hand expression
     * @param right
     *            The right hand expression
     * 
     * @return The expressions' type
     * 
     * @throws RuntimeException
     *             Thrown when the types don't match
     */
    public static Type getOperandType(final Expression left, final Expression right) {
        final Type leftType = left.getReturnType();
        final Type rightType = right.getReturnType();
        if (leftType != rightType) {
            throw new RuntimeException("Operand types " + leftType + " and " + rightType + " are not equal");
        }

        return leftType;
    }

    /**
     * This class is static-only.
     */
    private OperationHelper() {}
}
