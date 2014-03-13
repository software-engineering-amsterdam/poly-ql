package nl.uva.polyql.validation;

import nl.uva.polyql.model.expressions.operations.Operation;
import nl.uva.polyql.model.types.Type;

public class InvalidOperandError extends ValidationError {
    private final Type mLeft;
    private final Type mRight;
    private final String mOperatorSyntax;

    public InvalidOperandError(final Operation operation) {
        super(operation);
        mLeft = operation.getLeft().getReturnType();
        mRight = operation.getRight().getReturnType();
        mOperatorSyntax = operation.getOperator().getSyntax();
    }

    @Override
    public String getLabel() {
        return "Operand types " + mLeft + "-" + mRight + " unsupported for operator " + mOperatorSyntax;
    }
}
