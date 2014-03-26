package ql.error;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author orosu
 */
public class ErrorList
{
    private final ArrayList<IError> _value;

    public ErrorList()
    {
        this._value = new ArrayList<IError>();
    }

    public Iterator<IError> iterator()
    {
        return this._value.iterator();
    }

    public void add(IError error)
    {
        this._value.add(error);
    }

    public void addAll(ErrorList errorList)
    {
        Iterator<IError> iterator = errorList.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    public int size()
    {
        return this._value.size();
    }

    public IError get(int index)
    {
        return this._value.get(index);
    }
}
