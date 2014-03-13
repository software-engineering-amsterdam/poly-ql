package nl.uva.polyql.validation;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operations.Operator;
import nl.uva.polyql.model.types.Type;

public class InvalidOperandError extends ValidationError {
    private final Type mLeft;
    private final Type mRight;
    private final String mOperatorSyntax;

    public InvalidOperandError(final Expression left, final Operator operator, final Expression right) {
        this(left.getReturnType(), operator.getSyntax(), right.getReturnType());
    }

    public InvalidOperandError(final Type left, final String operatorSyntax, final Type right) {
        mLeft = left;
        mRight = right;
        mOperatorSyntax = operatorSyntax;
    }

    @Override
    public String toString() {
        return "Operand types " + mLeft + "-" + mRight + " unsupported for operator " + mOperatorSyntax;
    }
}
