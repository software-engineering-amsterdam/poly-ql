package nl.uva.polyql.validation;

import nl.uva.polyql.ast.IfStatement;
import nl.uva.polyql.ast.values.Type;

public class InvalidIfStatementError extends ValidationError {

    private final Type mType;

    public InvalidIfStatementError(final IfStatement ifStatement) {
        super(ifStatement);
        mType = ifStatement.getExpression().getReturnType();
    }

    @Override
    public String getLabel() {
        return "Invalid if-statement expression type: " + mType + ", should be " + Type.BOOLEAN;
    }
}
