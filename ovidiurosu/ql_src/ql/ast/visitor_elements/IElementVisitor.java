package ql.ast.visitor_elements;

import ql.ast.Questionnaire;

/**
 * @author orosu
 */
public interface IElementVisitor<T> extends IStatementElementVisitor<T>, IExpressionElementVisitor<T>
{
    public T visit(Questionnaire questionnaire);
}
