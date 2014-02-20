package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.operators.bool.*;
import nl.uva.polyql.model.expressions.operators.number.*;

public class OperatorHelper {

    private final static OperatorMap<Boolean> sBooleanSyntaxMap = new OperatorMap<>();
    private final static OperatorMap<Double> sNumberSyntaxMap = new OperatorMap<>();

    static {
        sBooleanSyntaxMap.put(new EqualsOperator());
        sBooleanSyntaxMap.put(new NotEqualsOperator());
        sBooleanSyntaxMap.put(new AndOperator());
        sBooleanSyntaxMap.put(new OrOperator());
        sBooleanSyntaxMap.put(new XorOperator());
        sBooleanSyntaxMap.put(new GreaterThanOperator());
        sBooleanSyntaxMap.put(new LesserThanOperator());
        sBooleanSyntaxMap.put(new GreaterThanOrEqualsOperator());
        sBooleanSyntaxMap.put(new LesserThanOrEqualsOperator());

        sNumberSyntaxMap.put(new AddOperator());
        sNumberSyntaxMap.put(new SubtractOperator());
        sNumberSyntaxMap.put(new MultiplyOperator());
        sNumberSyntaxMap.put(new DivideOperator());
    }

    public static Operator<Boolean> getBooleanOperator(final String operator) {
        return sBooleanSyntaxMap.get(operator);
    }

    public static Operator<Double> getNumberOperator(final String operator) {
        return sNumberSyntaxMap.get(operator);
    }
}
