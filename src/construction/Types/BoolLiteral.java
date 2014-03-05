package construction.Types;

import construction.ErrorTypes.TypeError;
import construction.Operators.Expression;
import java.util.List;
import java.util.Map;

public class BoolLiteral extends BoolType implements Expression {

    boolean value;
    int line;

    public BoolLiteral(String value, int line) {
        this.value = Boolean.parseBoolean(value);
        this.line = line;
    }

    public BoolLiteral(boolean value, int line) {
        this.value = value;
        this.line = line;
    }

    public String toString() {
        if (value) {
            return "BoolLiteral: True";
        }
        return "BoolLiteral: False";
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new BoolType();
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
