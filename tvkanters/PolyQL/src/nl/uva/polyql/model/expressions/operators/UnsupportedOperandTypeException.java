package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;

public class UnsupportedOperandTypeException extends UnsupportedOperationException {

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
