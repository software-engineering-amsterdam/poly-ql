package ql.ast.visitor_elements;

/**
 * @author orosu
 */
public interface INumberTypeElement
{
    public <T> T accept(INumberTypeElementVisitor<T> visitor);
}
