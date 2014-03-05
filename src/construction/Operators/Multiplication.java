/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.Operators;

import construction.Types.IType;
import construction.Types.IntType;
import construction.ErrorTypes.TypeError;
import java.util.List;
import java.util.Map;

/**
 *
 * @author svene_000
 */
public class Multiplication extends BinaryOperator {

    public Multiplication(Expression leftHandExpression, Expression rightHandExpression, int line) {
        super(leftHandExpression, rightHandExpression, line);
    }

    public String toString() {
        return "Left Hand: " + leftHandExpression.toString() + " Right Hand: " + rightHandExpression.toString();
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new IntType();
    }
/*
    @Override
    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        if (!leftHandExpression.checkType(map, typeErrors) || !rightHandExpression.checkType(map, typeErrors)) {
            return false;
        }
        if (!leftHandExpression.getType(map).isCompatible(new IntType()) || !rightHandExpression.getType(map).isCompatible(new IntType())) {
            return false;
        }
        return true;
    }
*/
}
