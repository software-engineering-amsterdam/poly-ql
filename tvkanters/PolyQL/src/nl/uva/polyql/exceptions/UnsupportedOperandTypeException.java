package nl.uva.polyql.exceptions;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public class UnsupportedOperandTypeException extends ParsingException {

    private static final long serialVersionUID = -4223641491733689837L;

    private final Type mLeft;
    private final Type mRight;
    private final String mOperatorSyntax;

    public UnsupportedOperandTypeException(final Type left, final String operatorSyntax, final Type right) {
        super("Operand types " + left + "-" + right + " unsupported for operator " + operatorSyntax);
        mLeft = left;
        mRight = right;
        mOperatorSyntax = operatorSyntax;
    }

    public UnsupportedOperandTypeException(final Expression left, final String operatorSyntax, final Expression right) {
        this(left.getReturnType(), operatorSyntax, right.getReturnType());
    }

    public UnsupportedOperandTypeException(final Type typeLeftRight, final String operatorSyntax) {
        this(typeLeftRight, operatorSyntax, typeLeftRight);
    }

    public UnsupportedOperandTypeException(final Value<?> leftValue, final Operator<?> operator,
            final Value<?> rightValue) {
        this(leftValue.getType(), operator.getSyntax(), rightValue.getType());
    }

    /**
     * Retrieves the type of the left argument of the operation
     * 
     * @return The left type
     */
    public Type getLeft() {
        return mLeft;
    }

    /**
     * Retrieves the type of the right argument of the operation
     * 
     * @return The right type
     */
    public Type getRight() {
        return mRight;
    }

    /**
     * The syntax of the operator for the operation. E.g., +
     * 
     * @return The operator's syntax
     */
    public String getOperatorSyntax() {
        return mOperatorSyntax;
    }

}
