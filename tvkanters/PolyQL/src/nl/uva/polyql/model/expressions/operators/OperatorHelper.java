package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.operators.bool.*;
import nl.uva.polyql.model.expressions.operators.number.*;

public class OperatorHelper {

    private final static OperatorMap<Boolean> sBooleanSyntaxMap = new OperatorMap<>();
    private final static OperatorMap<Double> sNumberSyntaxMap = new OperatorMap<>();
    private final static OperatorMap<String> sStringSyntaxMap = new OperatorMap<>();

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

        sStringSyntaxMap.put(new nl.uva.polyql.model.expressions.operators.string.AddOperator());
    }

    public static Operator<Boolean> getBooleanOperator(final String operator) {
        return sBooleanSyntaxMap.get(operator);
    }

    public static Operator<Double> getNumberOperator(final String operator) {
        return sNumberSyntaxMap.get(operator);
    }

    public static Operator<String> getStringOperator(final String operator) {
        return sStringSyntaxMap.get(operator);
    }

    public static boolean hasBooleanOperator(final String operator) {
        return sBooleanSyntaxMap.contains(operator);
    }

    public static boolean hasNumberOperator(final String operator) {
        return sNumberSyntaxMap.contains(operator);
    }

    public static boolean hasStringOperator(final String operator) {
        return sStringSyntaxMap.contains(operator);
    }
}
