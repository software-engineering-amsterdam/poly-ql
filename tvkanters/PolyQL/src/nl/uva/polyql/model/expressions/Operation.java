package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.expressions.operators.BooleanOperatorManager;

public class Operation implements IExpression {

    private IExpression mLeft;
    private BooleanOperatorManager mOperator;
    private IExpression mRight;

    public Operation(final IExpression left) {
        setLeft(left);
    }

    public void setLeft(final IExpression left) {
        mLeft = left;
    }

    public void setOperation(final BooleanOperatorManager operator, final IExpression right) {
        mOperator = operator;
        mRight = right;
    }

    public void setOperation(final String operator, final IExpression right) {
        mOperator = BooleanOperatorManager.valueOf(operator);
        mRight = right;
    }

    @Override
    public boolean validate() {
        return false;
    }

}
