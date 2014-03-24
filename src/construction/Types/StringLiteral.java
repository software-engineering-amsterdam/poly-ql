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
package construction.Types;

import construction.ErrorTypes.TypeError;
import construction.Operators.Expression;
import construction.Values.StringValue;
import construction.Values.Value;
import java.util.List;
import java.util.Map;

public class StringLiteral extends StringType implements Expression {

    String value;
    int line;

    public StringLiteral(String value, int line) {
        this.value = value;
        this.line = line;
    }

    public String toString() {
        return "StringLiteral: " + value;
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new StringType();
    }

    @Override
    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        return true;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public Value getValue(Map<String, Value> map) {
       return new StringValue(value);
    }

}
