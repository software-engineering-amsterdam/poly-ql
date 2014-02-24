package ql.ast.literal;

import ql.ast.type.STRINGType;
import ql.ast.visitor.IElementVisitor;

/**
 * String Literal
 * @author orosu
 */
public class STRINGLiteral extends Literal<String>
{
    /**
     * Constructor
     * @param value
     */
    public STRINGLiteral(String value)
    {
        super(value);
    }

    @Override
    public STRINGType getType()
    {
        return new STRINGType();
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        visitor.visit(this);
    }

}
