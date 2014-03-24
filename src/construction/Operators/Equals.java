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
import construction.Types.BoolType;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import construction.Values.BoolValue;
import construction.Values.IntValue;
import construction.Values.Value;
import java.util.List;
import java.util.Map;

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
        if (!leftHandExpression.getType(map).isCompatible(rightHandExpression.getType(map))) {
            typeErrors.add(new InvalidOperandError(leftHandExpression.getType(map), rightHandExpression.getType(map), leftHandExpression.getType(map), line));
            return false;
        }
        return true;
    }

    public Value getValue(Map<String, Value> map) {
        Value lhv = leftHandExpression.getValue(map);
        Value rhv = rightHandExpression.getValue(map);
        if (lhv.equals(rhv)) {
            return new BoolValue(true);
        }
        return new BoolValue(false);
    }

}
