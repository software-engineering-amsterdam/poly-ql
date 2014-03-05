/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.Types;

import construction.ErrorTypes.TypeError;
import construction.Operators.Expression;
import java.util.List;
import java.util.Map;

/**
 *
 * @author svene_000
 */
public class IntLiteral implements Expression {

    int value;
    int line;

    public IntLiteral(int value, int line) {
        this.value = value;
        this.line = line;
    }

    public String toString() {
        return "IntLiteral: " + value;
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new IntType();
    }

    @Override
    public boolean checkType(Map<String, IType> map, List<TypeError> typeErrors) {
        return true;
    }

    @Override
    public int getLine() {
        return line;
    }

}
