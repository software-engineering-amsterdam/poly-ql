package nl.uva.polyql.model.expressions.operators.string;

public class AddOperator extends StringOperator {

    public static final String SYNTAX = "+";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected String performOperation(String left, String right) {
        return left + right;
    }

}
