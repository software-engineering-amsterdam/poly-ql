package ql.ast.expr;

import ql.ast.type.IType;
import ql.ast.visitor.IElement;

/**
 * Expression Interface
 * @author orosu
 */
public interface IExpr extends IElement
{
    public IType getType();
}
