package ql.ast.literal;

import ql.ast.type.NUMType;
import ql.ast.visitor.IElementVisitor;


/**
 * Number Literal
 * @author orosu
 */
public class NUMLiteral extends Literal<Number>
{
    /**
     * Constructor
     * @param value
     */
    public NUMLiteral(Number value)
    {
        super(value);
    }

    @Override
    public NUMType getType()
    {
        return new NUMType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
