package ql.ast.type;

import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;

/**
 * Type Interface
 * @author orosu
 */
public interface IType
{
    public Boolean compatibleWith(BOOLEANStatType statType);
    public Boolean compatibleWith(MONEYStatType statType);
    public Boolean compatibleWith(TEXTStatType statType);

    public String toStr();
}
