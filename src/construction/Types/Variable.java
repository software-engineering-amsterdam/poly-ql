
package construction.Types;

import construction.ErrorTypes.TypeError;
import construction.ErrorTypes.UndefinedVariableError;
import construction.Operators.Expression;
import java.util.List;
import java.util.Map;

public class Variable implements Expression {

    String name;
    int line;

    public Variable(String name,int line) {
        this.name = name;
        this.line = line;
    }

    public IType getType(Map<String, IType> map) {
        if(map.containsKey(name))
        {
            return map.get(name);
        }
        return new ErrorType(line);
    }

    public boolean checkType(Map<String, IType> map,List<TypeError> typeErrors) {
        if(!map.containsKey(name))
        {
            typeErrors.add(new UndefinedVariableError(name,line));
            return false;
        }
        return true;
    }

    @Override
    public int getLine() {
        return line;
    }
    
    public String toString()
    {
        return "Variable";
    }

}
