package ql.ast.visitor;

/**
 * Element Interface
 * @author orosu
 */
public interface IElement
{
    void accept(IElementVisitor visitor);
}
