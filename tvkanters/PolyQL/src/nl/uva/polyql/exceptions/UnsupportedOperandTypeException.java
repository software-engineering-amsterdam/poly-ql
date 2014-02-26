package nl.uva.polyql.exceptions;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public class UnsupportedOperandTypeException extends ParsingException {

    private static final long serialVersionUID = 8634412238170543338L;

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

    public Type getLeft() {
        return mLeft;
    }

    public Type getRight() {
        return mRight;
    }

    public String getOperatorSyntax() {
        return mOperatorSyntax;
    }

}
