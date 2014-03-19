package ql.ast.expression;

import ql.ast.type.Type;
import ql.ast.visitor_elements.IElement;
import ql.ast.visitor_elements.IExpressionElement;

/**
 * @author orosu
 */
public interface IExpression extends IElement, IExpressionElement
{
    public Type getType();
}
