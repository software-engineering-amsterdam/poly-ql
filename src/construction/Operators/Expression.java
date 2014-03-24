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
import construction.ErrorTypes.TypeError;
import construction.Values.Value;
import java.util.List;
import java.util.Map;

public interface Expression {
    public IType getType(Map<String,IType> map);
    public boolean checkType(Map<String,IType> map,List<TypeError> typeErrors);
    public int getLine();
    public Value getValue(Map<String, Value> map);
}
