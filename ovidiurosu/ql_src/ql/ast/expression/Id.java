package ql.ast.expression;

import ql.ast.type.NullType;
import ql.ast.type.Type;
import ql.ast.visitor_elements.IExpressionElementVisitor;
import ql.type_checker.TypeEnvironment;

/**
 * @author orosu
 */
public class Id implements IExpression
{
    private final String _value;
    private final Type _type;
    private TypeEnvironment _typeEnvironment;

    public Id(String value)
    {
        this._value = value;
        this._type = new NullType();
    }

    public String getValue()
    {
        return this._value;
    }

    public void setTypeEnvironment(TypeEnvironment typeEnvironment)
    {
        this._typeEnvironment = typeEnvironment;
    }

    @Override
    public Type getType()
    {
        if (this._typeEnvironment != null &&
            this._typeEnvironment.hasType(this._value))
        {
            return this._typeEnvironment.getType(this._value);
        }
        return this._type;
    }

    @Override
    public String toString()
    {
        return "(expression " + this._value + ")";
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
