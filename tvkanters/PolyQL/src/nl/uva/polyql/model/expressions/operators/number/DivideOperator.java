package nl.uva.polyql.model.expressions.operators.number;

public class DivideOperator extends NumberOperator {

    public static final String SYNTAX = "/";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected Double performOperation(double left, double right) {
        return left / right;
    }

}
