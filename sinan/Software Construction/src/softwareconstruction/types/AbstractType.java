/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.types;

/**
 *
 * @author Sinan
 */
public class AbstractType implements SuperType {

    @Override
    public boolean isCompatible(SuperType SuperType) {
        return false;
    }

    @Override
    public boolean isBooleanCompatible() {
        return false;
    }

    @Override
    public boolean isStringCompatible() {
        return false;
    }

    @Override
    public boolean isIntegerCompatible() {
        return false;
    }
    
}
