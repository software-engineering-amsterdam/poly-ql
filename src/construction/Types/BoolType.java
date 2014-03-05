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
public class BoolType extends AbstractIType {

    public BoolType() {
    }


    @Override
    public boolean isCompatible(IType iType) {
        if(iType.isBooleanCompatible()) return true;
        return false;
    }

    @Override
    public boolean isBooleanCompatible() {
        return true;
    }

    public String toString() {
        return "boolean";
    }
}
