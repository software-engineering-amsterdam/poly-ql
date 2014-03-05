/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.Operators;

import construction.Types.IType;
import construction.Types.IntType;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import java.util.List;
import java.util.Map;

public abstract class BinaryOperator implements Expression {

    Expression leftHandExpression;
    Expression rightHandExpression;
    int line;

    public BinaryOperator(Expression leftHandExpression, Expression rightHandExpression, int line) {
        this.leftHandExpression = leftHandExpression;
        this.rightHandExpression = rightHandExpression;
        this.line = line;
    }

    public Expression getleftHandExpression() {
        return leftHandExpression;
    }

    public void setleftHandExpression(Expression leftHandExpression) {
        this.leftHandExpression = leftHandExpression;
    }

    public Expression getRightHandExpression() {
        return rightHandExpression;
    }

    public void setRightHandExpression(Expression rightHandExpression) {
        this.rightHandExpression = rightHandExpression;
    }

    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        if (!leftHandExpression.checkType(map, typeErrors) || !rightHandExpression.checkType(map, typeErrors)) {
            return false;
        }
        if (!leftHandExpression.getType(map).isCompatible(new IntType())) {
            typeErrors.add(new InvalidOperandError(leftHandExpression.getType(map), rightHandExpression.getType(map), new IntType(), line));
            return false;
        } else if (!rightHandExpression.getType(map).isCompatible(new IntType())) {
            typeErrors.add(new InvalidOperandError(leftHandExpression.getType(map), rightHandExpression.getType(map), new IntType(), line));
            return false;
        }
        return true;
    }

    @Override
    public int getLine() {
        return line;
    }

}
