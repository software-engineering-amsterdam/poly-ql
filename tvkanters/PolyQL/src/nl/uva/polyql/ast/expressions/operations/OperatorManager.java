package nl.uva.polyql.ast.expressions.operations;

import nl.uva.polyql.ast.expressions.operators.Add;
import nl.uva.polyql.ast.expressions.operators.And;
import nl.uva.polyql.ast.expressions.operators.Divide;
import nl.uva.polyql.ast.expressions.operators.Equals;
import nl.uva.polyql.ast.expressions.operators.GreaterThan;
import nl.uva.polyql.ast.expressions.operators.GreaterThanOrEquals;
import nl.uva.polyql.ast.expressions.operators.Not;
import nl.uva.polyql.ast.expressions.operators.LesserThan;
import nl.uva.polyql.ast.expressions.operators.LesserThanOrEquals;
import nl.uva.polyql.ast.expressions.operators.Multiply;
import nl.uva.polyql.ast.expressions.operators.Negative;
import nl.uva.polyql.ast.expressions.operators.NotEquals;
import nl.uva.polyql.ast.expressions.operators.Or;
import nl.uva.polyql.ast.expressions.operators.Subtract;
import nl.uva.polyql.ast.expressions.operators.Xor;
import nl.uva.polyql.utils.SyntaxMap;

/**
 * A class that contains and provides operators that are registered to it. When creating new
 * operators, they should be provided to this manager by calling {@link #register()}.
 */
public class OperatorManager {

    private final static SyntaxMap<BinaryOperator> sBinaryOperators = new SyntaxMap<>();
    private final static SyntaxMap<UnaryOperator> sUnaryOperators = new SyntaxMap<>();

    static {
        register(new Add());
        register(new And());
        register(new Divide());
        register(new Equals());
        register(new GreaterThan());
        register(new LesserThan());
        register(new GreaterThanOrEquals());
        register(new Not());
        register(new LesserThanOrEquals());
        register(new Multiply());
        register(new Negative());
        register(new NotEquals());
        register(new Or());
        register(new Subtract());
        register(new Xor());
    }

    public static void register(final BinaryOperator operator) {
        sBinaryOperators.put(operator);
    }

    public static void register(final UnaryOperator operator) {
        sUnaryOperators.put(operator);
    }

    public static BinaryOperator getBinaryOperator(final String syntax) {
        return sBinaryOperators.get(syntax);
    }

    public static UnaryOperator getUnaryOperator(final String syntax) {
        return sUnaryOperators.get(syntax);
    }

    /**
     * This class is static-only.
     */
    private OperatorManager() {}
}
