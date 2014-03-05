package construction.Types;

import construction.ErrorTypes.TypeError;
import construction.Operators.Expression;
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

}
