/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package construction.Types;

/**
 *
 * @author svene_000
 */
public interface IType {
    public boolean isCompatible(IType iType);
    public boolean isBooleanCompatible();
    public boolean isIntegerCompatible();
    public boolean isStringCompatible();
    public boolean isErrorCompatible();
}
