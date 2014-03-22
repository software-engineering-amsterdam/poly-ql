package ql.ast.expression_evaluator;

import java.util.LinkedHashMap;

import ql.ast.expression_value.IValue;
import ql.ast.expression_value.NullValue;

/**
 * @author orosu
 */
public class ValueEnvironment
{
    /*
     * id: value
     */
    private final LinkedHashMap<String, IValue> _values;

    public ValueEnvironment()
    {
        this._values = new LinkedHashMap<String, IValue>();
    }

    public IValue getById(String id)
    {
        if (!this._values.containsKey(id)){
            return new NullValue();
        }
        return this._values.get(id);
    }

    public void setValue(String id, IValue value)
    {
        this._values.put(id, value);
    }
}
