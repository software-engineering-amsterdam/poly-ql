package ql.gui.element.expression;

import java.util.LinkedHashSet;

import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.gui.element.IGuiElement;

/**
 * @author orosu
 */
public class ExpressionElement implements IGuiElement
{
    private final IExpression _expression;
    private final LinkedHashSet<Id> _involvedIds;

    public ExpressionElement(IExpression expression)
    {
        this._expression = expression;
        this._involvedIds = new LinkedHashSet<Id>();
    }

    public IExpression getExpression()
    {
        return this._expression;
    }

    public void addId(Id id)
    {
        this._involvedIds.add(id);
    }

    public LinkedHashSet<Id> getInvolvedIds()
    {
        return this._involvedIds;
    }
}
