package ql.ast.visitor_elements;

import ql.ast.statement.Assignment;
import ql.ast.statement.ComputedAssignment;
import ql.ast.statement.IfStatement;

/**
 * @author orosu
 */
public interface IStatementElementVisitor<T>
{
    public T visit(IfStatement ifStatement);
    public T visit(Assignment assignment);
    public T visit(ComputedAssignment computedAssignment);
}
