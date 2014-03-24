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

import construction.Values.StringValue;
import construction.Values.Value;

public class StringType extends AbstractIType {

    public StringType() {
    }

    @Override
    public boolean isCompatible(IType iType) {
        if (iType.isStringCompatible()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isStringCompatible() {
        return true;
    }

    public String toString() {
        return "string";
    }
    
     @Override
    public Value getUndefinedValue() {
        return new StringValue("");
    }
}
