package ql.ast.visitor_elements;

/**
 * @author orosu
 */
public interface IStatementElement
{
    public <T> T accept(IStatementElementVisitor<T> visitor);
}
