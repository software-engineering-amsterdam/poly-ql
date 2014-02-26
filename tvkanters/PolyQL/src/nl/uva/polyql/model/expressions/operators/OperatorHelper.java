package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.operators.bool.AndOperator;
import nl.uva.polyql.model.expressions.operators.bool.EqualsOperator;
import nl.uva.polyql.model.expressions.operators.bool.GreaterThanOperator;
import nl.uva.polyql.model.expressions.operators.bool.GreaterThanOrEqualsOperator;
import nl.uva.polyql.model.expressions.operators.bool.LesserThanOperator;
import nl.uva.polyql.model.expressions.operators.bool.LesserThanOrEqualsOperator;
import nl.uva.polyql.model.expressions.operators.bool.NotEqualsOperator;
import nl.uva.polyql.model.expressions.operators.bool.OrOperator;
import nl.uva.polyql.model.expressions.operators.bool.XorOperator;
import nl.uva.polyql.model.expressions.operators.number.AddOperator;
import nl.uva.polyql.model.expressions.operators.number.DivideOperator;
import nl.uva.polyql.model.expressions.operators.number.MultiplyOperator;
import nl.uva.polyql.model.expressions.operators.number.SubtractOperator;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.utils.SyntaxMap;

public class OperatorHelper {

    private final static SyntaxMap<Operator<BooleanValue>> sBooleanSyntaxMap = new SyntaxMap<>();
    private final static SyntaxMap<Operator<NumberValue>> sNumberSyntaxMap = new SyntaxMap<>();
    private final static SyntaxMap<Operator<StringValue>> sStringSyntaxMap = new SyntaxMap<>();

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

    public static Operator<BooleanValue> getBooleanOperator(final String operator) {
        return sBooleanSyntaxMap.get(operator);
    }

    public static Operator<NumberValue> getNumberOperator(final String operator) {
        return sNumberSyntaxMap.get(operator);
    }

    public static Operator<StringValue> getStringOperator(final String operator) {
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

    /**
     * This class is static-only.
     */
    private OperatorHelper() {}
}
