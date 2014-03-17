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
}
