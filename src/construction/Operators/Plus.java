package construction.Operators;

import construction.Types.IType;
import construction.Types.IntType;
import java.util.Map;

public class Plus extends BinaryOperator {

    public Plus(Expression leftHandExpression, Expression rightHandExpression, int line) {
        super(leftHandExpression, rightHandExpression, line);
    }

    @Override
    public String toString() {
        return "PLUS:   Left Hand: " + leftHandExpression.toString() + " Right Hand: " + rightHandExpression.toString();
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new IntType();
    }

}
