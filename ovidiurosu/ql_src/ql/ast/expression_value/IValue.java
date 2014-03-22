package ql.ast.expression_value;

import ql.ast.visitor_elements.IElement;
import ql.ast.visitor_elements.IValueElement;

/**
 * @author orosu
 */
public interface IValue extends IElement, IValueElement
{
    public Object getValue();
    public boolean equals(IValue value);
    public boolean equalsValue(IValue value);
}
