package ql.ast.expression;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author orosu
 */
public class IdSet
{
    private final Set<Id> _value;

    public IdSet()
    {
        this._value = new HashSet<Id>();
    }

    public Iterator<Id> iterator()
    {
        return this._value.iterator();
    }

    public void add(Id id)
    {
        this._value.add(id);
    }

    public void addAll(IdSet idSet)
    {
        Iterator<Id> iterator = idSet.iterator();
        while(iterator.hasNext()) {
            this.add(iterator.next());
        }
    }
}
