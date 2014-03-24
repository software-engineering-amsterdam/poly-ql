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

import construction.Values.BoolValue;
import construction.Values.Value;

public class ErrorType extends AbstractIType {

    boolean value;
    int line;

    public ErrorType(int line) {
        this.line = line;
    }

    public ErrorType() {

    }

    public void setValue() {
    }

    public String toString() {
        return "Undefined";
    }

    public boolean isCompatible(IType iType) {
        if (iType.isErrorCompatible()) {
            return true;
        }
        return false;
    }

    public boolean isErrorCompatible() {
        return true;
    }

    @Override
    public Value getUndefinedValue() {
        return new BoolValue(false);
    }

}
