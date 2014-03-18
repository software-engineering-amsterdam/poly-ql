package ql.ast.visitor_elements;

/**
 * @author orosu
 */
public interface IExpressionElement
{
    public <T> T accept(IExpressionElementVisitor<T> visitor);
}
