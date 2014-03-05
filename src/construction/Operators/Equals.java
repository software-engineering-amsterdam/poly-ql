/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.Operators;

import construction.Types.IType;
import construction.Types.BoolType;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import java.util.List;
import java.util.Map;

/**
 *
 * @author svene_000
 */
public class Equals extends BinaryOperator {

    public Equals(Expression leftHandExpression, Expression rightHandExpression, int line) {
        super(leftHandExpression, rightHandExpression, line);
    }

    public String toString() {
        return "Left Hand: " + leftHandExpression.toString() + " Right Hand: " + rightHandExpression.toString();
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new BoolType();
    }

    @Override
    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        if (!leftHandExpression.checkType(map, typeErrors) || !rightHandExpression.checkType(map, typeErrors)) {
            
            return false;
        }
        if(!leftHandExpression.getType(map).isCompatible(rightHandExpression.getType(map)))
        {
            typeErrors.add(new InvalidOperandError(leftHandExpression.getType(map), rightHandExpression.getType(map), leftHandExpression.getType(map), line));
            return false;
        }
        return true;
    }

}
