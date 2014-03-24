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

import construction.Types.BoolType;
import construction.Types.IType;
import construction.Values.BoolValue;
import construction.Values.IntValue;
import construction.Values.Value;
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
    
            @Override
    public Value getValue(Map<String, Value> map) {
        IntValue lhv = (IntValue) leftHandExpression.getValue(map);
        IntValue rhv = (IntValue) rightHandExpression.getValue(map);
        if(lhv.getIntValue() < rhv.getIntValue()) return new BoolValue(true);
        return new BoolValue(false);
    }


}
