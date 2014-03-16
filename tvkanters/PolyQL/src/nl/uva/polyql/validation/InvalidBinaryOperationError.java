package nl.uva.polyql.validation;

import nl.uva.polyql.ast.expressions.operations.BinaryOperation;
import nl.uva.polyql.ast.types.Type;

public class InvalidBinaryOperationError extends ValidationError {
    private final Type mLeft;
    private final Type mRight;
    private final String mOperatorSyntax;

    public InvalidBinaryOperationError(final BinaryOperation operation) {
        super(operation);
        mLeft = operation.getLeft().getReturnType();
        mRight = operation.getRight().getReturnType();
        mOperatorSyntax = operation.getOperator().getSyntax();
    }

    @Override
    public String getLabel() {
        return "Operand types " + mLeft + "-" + mRight + " unsupported for operator '" + mOperatorSyntax + "'";
    }
}
