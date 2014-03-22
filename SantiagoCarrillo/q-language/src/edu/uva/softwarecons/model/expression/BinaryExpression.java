package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/20/14
 */
public abstract class BinaryExpression
    implements Expression
{

    protected final Expression leftExpression;

    protected final Expression rightExpression;


    protected BinaryExpression( Expression leftExpression, Expression rightExpression )
    {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression()
    {
        return leftExpression;
    }

    public Expression getRightExpression()
    {
        return rightExpression;
    }

    public abstract BinaryExpression getNewInstance( Expression leftOperand, Expression rightOperand );
}
