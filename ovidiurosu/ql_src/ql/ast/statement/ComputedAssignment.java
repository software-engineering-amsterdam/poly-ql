package ql.ast.statement;

import ql.ast.expression.IExpression;
import ql.ast.type.Type;
import ql.ast.visitor_elements.IStatementElementVisitor;

/**
 * @author orosu
 */
public class ComputedAssignment extends Assignment implements IStatement, IAssignment
{
    private final IExpression _expression;

    public ComputedAssignment(String id, String label, Type type, IExpression expression)
    {
        super(id, label, type);
        this._expression = expression;
    }

    public IExpression getExpression()
    {
        return _expression;
    }

    @Override
    public String toString()
    {
        return "(statement " + this._id + " : \"" + this._label + "\" " +
               this._type.toString() + " ( " + this._expression.toString() + " ))";
    }

    @Override
    public <T> T accept(IStatementElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
