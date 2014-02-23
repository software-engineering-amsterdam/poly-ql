package nl.uva.polyql.model.expressions.operators.string;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class StringOperator extends Operator<String> {

    @Override
    protected String performOperation(final Expression left, final Expression right) {
        final Types leftType = left.getReturnType();
        final Types rightType = right.getReturnType();

        final String leftValue;
        final String rightValue;

        switch (leftType) {
        case STRING:
        case NUMBER:
            leftValue = left.getValue().toString();
            break;
        default:
            throw new UnsupportedOperandTypeException(leftType, getSyntax(), rightType);
        }

        switch (rightType) {
        case STRING:
        case NUMBER:
            rightValue = right.getValue().toString();
            break;
        default:
            throw new UnsupportedOperandTypeException(leftType, getSyntax(), rightType);
        }

        return performOperation(leftValue, rightValue);
    }

    protected abstract String performOperation(final String left, final String right);

    @Override
    public boolean isValid(final Types leftType, final Types rightType) {
        boolean valid = true;

        switch (leftType) {
        case STRING:
        case NUMBER:
            break;
        default:
            valid = false;
        }

        switch (rightType) {
        case STRING:
        case NUMBER:
            break;
        default:
            valid = false;
        }

        return valid;
    }
}
