package ql.type_checker;

import ql.error.ErrorList;

/**
 * @author orosu
 */
public abstract class Checker
{
    protected final TypeEnvironment _typeEnvironment;
    protected final ErrorList _errorList;

    public Checker(TypeEnvironment typeEnvironment, ErrorList errorList)
    {
        this._typeEnvironment = typeEnvironment;
        this._errorList = errorList;
    }

    public ErrorList getErrorList()
    {
        return this._errorList;
    }
}
