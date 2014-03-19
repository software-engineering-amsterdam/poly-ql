package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.StringValue;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 3/12/14
 */
public class StringExpression
    implements Expression
{

    private String value;

    public StringExpression( String value )
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public Type accept( IExpressionElementVisitor visitor )
    {
        return new StringType();
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof StringExpression;
    }

    @Override
    public Value accept( IExpressionEvalVisitor visitor )
    {
        return new StringValue( value );
    }
}
