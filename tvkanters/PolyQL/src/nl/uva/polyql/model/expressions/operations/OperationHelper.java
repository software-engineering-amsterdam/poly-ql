package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.exceptions.UnsupportedOperandTypeException;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.types.Type;

public class OperationHelper {

    /**
     * Retrieves an operation that matches the operand expressions' types and the operator syntax.
     * 
     * @param left
     *            The left hand expression
     * @param operator
     *            The syntax of the operator to perform
     * @param right
     *            The right hand expression
     * 
     * @return The best option for the operation to perform on the arguments
     * 
     * @throws UnsupportedOperandTypeException
     *             Thrown when no suitable operation could be found (when the DSL user made a
     *             mistake in the QL form)
     */
    public static Operation<?> getOperation(final Expression left, final String operator, final Expression right) {

        final Type leftType = left.getReturnType();
        final Type rightType = right.getReturnType();

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
