package nl.uva.polyql.model.expressions;

import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.Operator;

public abstract class Operation<T> extends Expression {

    private final Type mOperandType;
    private final Expression mLeft;
    private final Operator<T> mOperator;
    private final Expression mRight;

    public Operation(final Expression left, final String operator, final Expression right) {
        final Type leftType = left.getReturnType();
        final Type rightType = right.getReturnType();
        if (leftType != rightType) {
            throw new RuntimeException("Operand types " + leftType + " and " + rightType + " are not equal");
        }

        mOperandType = leftType;
        mLeft = left;
        mOperator = getOperator(operator);
        mRight = right;

        System.out.println("OPERATION " + this);
    }

    public T getValue() {
        return mOperator.performOperation(this);
    }

    protected abstract Operator<T> getOperator(final String operator);

    public Type getOperandType() {
        return mOperandType;
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
