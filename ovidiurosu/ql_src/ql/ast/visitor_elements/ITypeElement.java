package ql.ast.visitor_elements;

/**
 * @author orosu
 */
public interface ITypeElement
{
    public <T> T accept(ITypeElementVisitor<T> visitor);
}
