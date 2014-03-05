package construction.Operators;

import construction.Types.BoolType;
import construction.Types.IType;
import java.util.Map;

public class SmallerThan extends BinaryOperator {

    public SmallerThan(Expression leftHandExpression, Expression rightHandExpression, int line) {
        super(leftHandExpression, rightHandExpression, line);
    }

    @Override
    public String toString() {
        return "<:   Left Hand: " + leftHandExpression.toString() + " Right Hand: " + rightHandExpression.toString();
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new BoolType();
    }

}
