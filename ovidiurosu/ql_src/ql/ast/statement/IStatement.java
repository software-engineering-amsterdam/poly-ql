package ql.ast.statement;

import ql.ast.type.Type;
import ql.ast.visitor_elements.IElement;
import ql.ast.visitor_elements.IStatementElement;

/**
 * @author orosu
 */
public interface IStatement extends IElement, IStatementElement
{
    public Type getType();
}
