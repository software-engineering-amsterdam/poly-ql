package nl.uva.polyql.ast.expressions.operations;

import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.validation.InvalidBinaryOperationError;
import nl.uva.polyql.validation.ValidationErrors;

public class BinaryOperation extends Operation {

    private final Expression mLeft;
    private final BinaryOperator mOperator;
    private final Expression mRight;

    public BinaryOperation(final Expression left, final String operatorSyntax, final Expression right) {
        mLeft = left;
        mOperator = OperatorManager.getBinaryOperator(operatorSyntax);
        mRight = right;

        if (mOperator == null) {
            throw new UnsupportedOperationException();
        }

        Log.i("OPERATION " + this);
    }

    public Expression getLeft() {
        return mLeft;
    }

    public BinaryOperator getOperator() {
        return mOperator;
    }

    public Expression getRight() {
        return mRight;
    }

    @Override
    public String toString() {
        return "(" + mLeft + " " + mOperator + " " + mRight + ")";
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = mLeft.getReferencedQuestions();
        questions.addAll(mRight.getReferencedQuestions());
        return questions;
    }

    private void recalculate() {
        setValue(mOperator.performOperation(this));
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = mLeft.validate();
        errors.merge(mRight.validate());

        if (!errors.isFatal()) {
            recalculate();
            if (!isValid()) {
                errors.add(new InvalidBinaryOperationError(this));
            }
        }

        return errors;
    }
}
