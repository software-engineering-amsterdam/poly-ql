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
import construction.ErrorTypes.UndefinedVariableError;
import construction.Operators.Expression;
import construction.Values.Value;
import java.util.List;
import java.util.Map;

public class Variable implements Expression {

    String name;
    int line;

    public Variable(String name, int line) {
        this.name = name;
        this.line = line;
    }

    public IType getType(Map<String, IType> map) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return new ErrorType(line);
    }

    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        if (!map.containsKey(name)) {
            typeErrors.add(new UndefinedVariableError(name, line));
            return false;
        }
        return true;
    }

    @Override
    public int getLine() {
        return line;
    }

    public String toString() {
        return "Variable";
    }

    public Value getValue(Map<String, Value> map) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

}
