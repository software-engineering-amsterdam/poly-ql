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
public class AbstractIType implements IType {

    @Override
    public boolean isCompatible(IType iType) {
        return false;
    }

    @Override
    public boolean isBooleanCompatible() {
        return false;
    }

    @Override
    public boolean isIntegerCompatible() {
        return false;
    }

    @Override
    public boolean isStringCompatible() {
        return false;
    }

    @Override
    public boolean isErrorCompatible() {
        return false;
    }

}
