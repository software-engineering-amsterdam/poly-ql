package nl.uva.polyql.model.expressions.operations;

import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public class Operation extends Expression {

    private final Expression mLeft;
    private final Operator mOperator;
    private final Expression mRight;

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
        return mOperator.performOperation(this);
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

    public Expression getRight() {
        return mRight;
    }

    @Override
    public String toString() {
        return "(" + mLeft + " " + mOperator + " " + mRight + ") = " + getValue();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = mLeft.getReferencedQuestions();
        questions.addAll(mRight.getReferencedQuestions());
        return questions;
    }
}
