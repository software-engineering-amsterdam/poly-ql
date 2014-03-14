package nl.uva.polyql.ast.expressions.operations;

import nl.uva.polyql.ast.expressions.operators.Add;
import nl.uva.polyql.ast.expressions.operators.And;
import nl.uva.polyql.ast.expressions.operators.Divide;
import nl.uva.polyql.ast.expressions.operators.Equals;
import nl.uva.polyql.ast.expressions.operators.GreaterThan;
import nl.uva.polyql.ast.expressions.operators.GreaterThanOrEquals;
import nl.uva.polyql.ast.expressions.operators.LesserThan;
import nl.uva.polyql.ast.expressions.operators.LesserThanOrEquals;
import nl.uva.polyql.ast.expressions.operators.Multiply;
import nl.uva.polyql.ast.expressions.operators.NotEquals;
import nl.uva.polyql.ast.expressions.operators.Or;
import nl.uva.polyql.ast.expressions.operators.Subtract;
import nl.uva.polyql.ast.expressions.operators.Xor;
import nl.uva.polyql.utils.SyntaxMap;

public class OperatorHelper {

    private final static SyntaxMap<Operator> sSyntaxMap = new SyntaxMap<>();

    static {
        sSyntaxMap.put(new Equals());
        sSyntaxMap.put(new NotEquals());
        sSyntaxMap.put(new And());
        sSyntaxMap.put(new Or());
        sSyntaxMap.put(new Xor());
        sSyntaxMap.put(new GreaterThan());
        sSyntaxMap.put(new LesserThan());
        sSyntaxMap.put(new GreaterThanOrEquals());
        sSyntaxMap.put(new LesserThanOrEquals());
        sSyntaxMap.put(new Add());
        sSyntaxMap.put(new Subtract());
        sSyntaxMap.put(new Multiply());
        sSyntaxMap.put(new Divide());
    }

    public static Operator getOperator(final String operator) {
        return sSyntaxMap.get(operator);
    }

    /**
     * This class is static-only.
     */
    private OperatorHelper() {}
}
