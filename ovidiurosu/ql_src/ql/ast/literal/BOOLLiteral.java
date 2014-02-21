package ql.ast.literal;

import ql.ast.type.BOOLType;
import ql.ast.visitor.IElementVisitor;

/**
 * Boolean Literal
 * @author orosu
 */
public class BOOLLiteral extends Literal<Boolean>
{
    /**
     * Constructor
     * @param value
     */
    public BOOLLiteral(Boolean value)
    {
        super(value);
    }

    @Override
    public BOOLType getType()
    {
        return new BOOLType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
