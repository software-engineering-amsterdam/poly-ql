package ql.ast.statement;

import ql.ast.type.Type;
import ql.ast.visitor_elements.IStatementElementVisitor;

/**
 * @author orosu
 */
public class Assignment implements IStatement, IAssignment
{
    protected final String _id;
    protected final String _label;
    protected final Type _type;

    public Assignment(String id, String label, Type type)
    {
        this._id = id;
        this._label = label;
        this._type = type;
    }

    @Override
    public String getId()
    {
        return _id;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    @Override
    public Type getType()
    {
        return _type;
    }

    @Override
    public String toString()
    {
        return "(statement " + this._id + " : \"" + this._label + "\" " +
               this._type.toString() + ")";
    }

    @Override
    public <T> T accept(IStatementElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
