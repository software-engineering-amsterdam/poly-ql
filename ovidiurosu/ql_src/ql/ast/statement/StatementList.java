package ql.ast.statement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author orosu
 */
public class StatementList
{
    private final ArrayList<IStatement> _value;

    public StatementList()
    {
        this._value = new ArrayList<IStatement>();
    }

    public Iterator<IStatement> iterator()
    {
        return this._value.iterator();
    }

    public int size()
    {
        return this._value.size();
    }

    public void add(IStatement statement)
    {
        this._value.add(statement);
    }
}
