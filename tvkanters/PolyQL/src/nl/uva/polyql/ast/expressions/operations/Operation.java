package nl.uva.polyql.ast.expressions.operations;

import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.validation.InvalidOperandError;
import nl.uva.polyql.validation.ValidationErrors;

public class Operation extends Expression {

    private final Expression mLeft;
    private final Operator mOperator;
    private final Expression mRight;
    private Value<?> mValue;

    public Operation(final Expression left, final String operator, final Expression right) {
        mLeft = left;
        mOperator = getOperator(operator);
        mRight = right;

        if (mOperator == null) {
            throw new UnsupportedOperationException();
        }

        Log.i("OPERATION " + this);
    }

    @Override
    public Value<?> getValue() {
        return mValue;
    }

    @Override
    public Type getReturnType() {
        return getValue().getType();
    }

    protected Operator getOperator(final String operator) {
        return OperatorHelper.getOperator(operator);
    }

    public Expression getLeft() {
        return mLeft;
    }

    public Operator getOperator() {
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
        mValue = mOperator.performOperation(this);
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = mLeft.validate();
        errors.merge(mRight.validate());

        if (!errors.isFatal()) {
            recalculate();
            if (!isValid()) {
                errors.add(new InvalidOperandError(this));
            }
        }

        return errors;
    }

    @Override
    public boolean isValid() {
        return mValue.getType() != Type.INVALID;
    }
}
