package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Type;
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
        throw new UnsupportedOperandTypeException(Type.NUMBER, SYNTAX);
    }

    @Override
    protected Boolean performOperation(String left, String right) {
        throw new UnsupportedOperandTypeException(Type.STRING, SYNTAX);
    }

    @Override
    public boolean isValidForImplementedType(final Type type) {
        return type == Type.BOOLEAN;
    }

}
