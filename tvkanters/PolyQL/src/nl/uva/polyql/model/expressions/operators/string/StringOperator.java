package nl.uva.polyql.model.expressions.operators.string;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class StringOperator extends Operator<String> {

    @Override
    protected String performOperation(final Types operandType, final Object left, final Object right) {
        switch (operandType) {
        case STRING:
            return performOperation((String) left, (String) right);

        default:
            throw new UnsupportedOperandTypeException(operandType);
        }
    }

    protected abstract String performOperation(final String left, final String right);
}
