package nl.uva.polyql.validation;

import nl.uva.polyql.ast.expressions.operations.UnaryOperation;
import nl.uva.polyql.ast.types.Type;

public class InvalidUnaryOperationError extends ValidationError {
    private final Type mType;
    private final String mOperatorSyntax;

    public InvalidUnaryOperationError(final UnaryOperation operation) {
        super(operation);
        mType = operation.getExpression().getReturnType();
        mOperatorSyntax = operation.getOperator().getSyntax();
    }

    @Override
    public String getLabel() {
        return "Operand type " + mType + " unsupported for operator '" + mOperatorSyntax + "'";
    }
}
