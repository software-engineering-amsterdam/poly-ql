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
import nl.uva.polyql.utils.SyntaxMap;

public class OperatorHelper {

    private final static SyntaxMap<Operator> sSyntaxMap = new SyntaxMap<>();

    static {
        sSyntaxMap.put(new EqualsOperator());
        sSyntaxMap.put(new NotEqualsOperator());
        sSyntaxMap.put(new AndOperator());
        sSyntaxMap.put(new OrOperator());
        sSyntaxMap.put(new XorOperator());
        sSyntaxMap.put(new GreaterThanOperator());
        sSyntaxMap.put(new LesserThanOperator());
        sSyntaxMap.put(new GreaterThanOrEqualsOperator());
        sSyntaxMap.put(new LesserThanOrEqualsOperator());

        sSyntaxMap.put(new AddOperator());
        sSyntaxMap.put(new SubtractOperator());
        sSyntaxMap.put(new MultiplyOperator());
        sSyntaxMap.put(new DivideOperator());
    }

    public static Operator getOperator(final String operator) {
        return sSyntaxMap.get(operator);
    }

    /**
     * This class is static-only.
     */
    private OperatorHelper() {}
}
