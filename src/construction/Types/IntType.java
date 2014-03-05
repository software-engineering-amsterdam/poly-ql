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
public class IntType extends AbstractIType {

    public IntType() {
    }

    @Override
    public boolean isCompatible(IType iType) {
        if (iType.isIntegerCompatible()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isIntegerCompatible() {
        return true;
    }

    public String toString() {
        return "integer";
    }
}
