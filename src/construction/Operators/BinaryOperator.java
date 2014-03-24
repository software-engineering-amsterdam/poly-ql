/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction.Operators;

import construction.Types.IType;
import construction.Types.IntType;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import construction.Values.Value;
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
    
    public Value getValue(Map<String, Value> map)
    {
        return null;
    }

}
