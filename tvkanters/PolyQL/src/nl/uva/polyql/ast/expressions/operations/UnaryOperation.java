package nl.uva.polyql.ast.expressions.operations;

import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.utils.Log;
import nl.uva.polyql.validation.InvalidUnaryOperationError;
import nl.uva.polyql.validation.ValidationErrors;

public class UnaryOperation extends Operation {

    private final UnaryOperator mOperator;
    private final Expression mExpression;

    public UnaryOperation(final String operatorSyntax, final Expression expression) {
        mOperator = OperatorManager.getUnaryOperator(operatorSyntax);
        mExpression = expression;

        if (mOperator == null) {
            throw new UnsupportedOperationException();
        }

        Log.i("OPERATION " + this);
    }

    public UnaryOperator getOperator() {
        return mOperator;
    }

    public Expression getExpression() {
        return mExpression;
    }

    @Override
    public String toString() {
        return "(" + mOperator + mExpression + ")";
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        return mExpression.getReferencedQuestions();
    }

    private void recalculate() {
        setValue(mOperator.performOperation(this));
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = mExpression.validate();

        if (!errors.isFatal()) {
            recalculate();
            if (!isValid()) {
                errors.add(new InvalidUnaryOperationError(this));
            }
        }

        return errors;
    }

}
