package nl.uva.polyql.model.expressions.operations;

import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.exceptions.UnsupportedOperandTypeException;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public abstract class Operation<T extends Value<?>> extends Expression {

    private final Expression mLeft;
    private final Operator<T> mOperator;
    private final Expression mRight;

    public Operation(final Expression left, final String operator, final Expression right) {
        mLeft = left;
        mOperator = getOperator(operator);
        mRight = right;

        if (mOperator == null) {
            throw new UnsupportedOperandTypeException(left, operator, right);
        }

        Log.i("OPERATION " + this);
    }

    public T getValue() {
        return mOperator.performOperation(this);
    }

    protected abstract Operator<T> getOperator(final String operator);

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

    public static boolean isValid(final Type leftType, final Operator<?> operator, final Type rightType) {
        return operator != null && operator.isValid(leftType, rightType);
    }
}
