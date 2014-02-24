package ql.ast.stat;

import ql.ast.stat.type.IStatType;
import ql.ast.visitor.IElement;

/**
 * Statement Interface
 * @author orosu
 */
public interface IStat extends IElement
{
    public IStatType getStatType();
}
