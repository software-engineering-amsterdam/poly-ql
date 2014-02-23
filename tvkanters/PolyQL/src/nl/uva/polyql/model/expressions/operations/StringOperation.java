package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;

public class StringOperation extends Operation<String> {

    public StringOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Types getReturnType() {
        return Types.STRING;
    }

    @Override
    protected Operator<String> getOperator(final String operator) {
        return OperatorHelper.getStringOperator(operator);
    }

    public static boolean isValid(final Types leftType, final String operator, final Types rightType) {
        return Operation.isValid(leftType, OperatorHelper.getStringOperator(operator), rightType);
    }

}
