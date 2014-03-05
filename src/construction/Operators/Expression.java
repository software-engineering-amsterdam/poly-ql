/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package construction.Operators;

import construction.Types.IType;
import construction.ErrorTypes.TypeError;
import java.util.List;
import java.util.Map;

/**
 *
 * @author svene_000
 */
public interface Expression {
    public IType getType(Map<String,IType> map);
    public boolean checkType(Map<String,IType> map,List<TypeError> typeErrors);
    public int getLine();
}
