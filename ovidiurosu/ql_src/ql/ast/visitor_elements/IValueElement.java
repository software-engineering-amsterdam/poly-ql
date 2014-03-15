package ql.ast.visitor_elements;

/**
 * @author orosu
 */
public interface IValueElement
{
    public <T> T accept(IValueElementVisitor<T> visitor);
}
