package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public class GreaterThanOperator extends BooleanOperator {

    public static final String SYNTAX = ">";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected Boolean performOperation(boolean left, boolean right) {
        throw new UnsupportedOperandTypeException(Type.BOOLEAN);
    }

    @Override
    protected Boolean performOperation(double left, double right) {
        return left > right;
    }

}
