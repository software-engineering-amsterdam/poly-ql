package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/20/14
 */
public abstract class UnaryExpression
    implements Expression
{

    private final Expression argument;


    public UnaryExpression( Expression argument )
    {
        this.argument = argument;
    }

    public Expression getArgument()
    {
        return argument;
    }
}
