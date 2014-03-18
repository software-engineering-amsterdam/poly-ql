package ql.ast.expression.value;

import ql.ast.visitor_elements.IElement;
import ql.ast.visitor_elements.IValueElement;

/**
 * @author orosu
 */
public interface IValue extends IElement, IValueElement
{
    public boolean equals(IValue value);

    public boolean equal(IValue value);
}
