package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.form.FormElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class ComputedQuestion
    extends BasicQuestion
{

    private final Expression expression;

    public ComputedQuestion( String id, String text, Type type, Expression expression )
    {
        super( id, text, type );
        this.expression = expression;
    }

    public Expression getExpression()
    {
        return expression;
    }

    @Override
    public void accept( FormElementVisitor visitor )
    {
        visitor.visitComputedQuestion( this );
    }

    @Override
    public String toString()
    {
        return id + ": " + text + " " + type + "(";
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof ComputedQuestion;
    }
}
