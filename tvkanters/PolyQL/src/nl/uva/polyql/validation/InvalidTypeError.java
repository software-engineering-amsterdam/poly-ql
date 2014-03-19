package nl.uva.polyql.validation;

import nl.uva.polyql.ast.CalculatedQuestion;
import nl.uva.polyql.ast.values.Type;

public class InvalidTypeError extends ValidationError {
    private final Type mType;
    private final Type mExpressionType;

    public InvalidTypeError(final CalculatedQuestion calculatedQuestion) {
        super(calculatedQuestion);
        mType = calculatedQuestion.getType();
        mExpressionType = calculatedQuestion.getExpression().getReturnType();
    }

    @Override
    public String getLabel() {
        return "Question type " + mType + " does not match the expression type " + mExpressionType;
    }
}
