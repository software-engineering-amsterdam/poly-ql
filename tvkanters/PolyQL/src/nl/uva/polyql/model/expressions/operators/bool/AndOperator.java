package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public class AndOperator extends BooleanOperator {

    public static final String SYNTAX = "&&";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected Boolean performOperation(boolean left, boolean right) {
        return left && right;
    }

    @Override
    protected Boolean performOperation(double left, double right) {
        throw new UnsupportedOperandTypeException(Types.NUMBER);
    }

    @Override
    protected Boolean performOperation(String left, String right) {
        throw new UnsupportedOperandTypeException(Types.STRING);
    }

}
