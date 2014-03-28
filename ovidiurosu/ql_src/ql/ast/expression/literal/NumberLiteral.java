package ql.ast.expression.literal;

/**
 * @author orosu
 */
public abstract class NumberLiteral extends Literal<Number> implements IEnumElement, IRangeElement
{
    public NumberLiteral(Number value)
    {
        super(value);
    }

    @Override
    public String toString()
    {
        return "(expression (numberLiteralP " + this.getLiteral().toString() + "))";
    }

    @Override
    public String enumToString()
    {
        return "(numberLiteralP " + this.getLiteral().toString() + ")";
    }
}
