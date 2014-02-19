package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorManager;

public abstract class Operation<T> extends Expression {

    private final Type mOperandType;
    private final Expression mLeft;
    private final Operator<T> mOperator;
    private final Expression mRight;

    public Operation(final Expression left, final String operator, final Expression right) {

        final Type leftType = left.getReturnType();
        final Type rightType = right.getReturnType();
        if (leftType != rightType) {
            throw new RuntimeException("Operand types " + leftType + " and " + rightType + " are not equal!");
        }
        mOperandType = leftType;

        mLeft = left;
        mOperator = getOperator(operator);
        mRight = right;

        System.out.println(this);
    }

    public T getValue() {
        return mOperator.performOperation(this);
    }

    @SuppressWarnings("unchecked")
    protected Operator<T> getOperator(final String operatorSyntax) {
        final Operator<?> operator;

        switch (getReturnType()) {
        case BOOLEAN:
            operator = OperatorManager.getBooleanOperator(operatorSyntax);
            break;

        case NUMBER:
            operator = OperatorManager.getNumberOperator(operatorSyntax);
            break;

        default:
            throw new RuntimeException("Invalid return type");
        }

        return (Operator<T>) operator;
    }

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
        return "(" + mLeft + " " + mOperator + " " + mRight + ")";
    }
}
