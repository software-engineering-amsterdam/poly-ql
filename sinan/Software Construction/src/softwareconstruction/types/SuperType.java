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
public interface SuperType {
    boolean isCompatible(SuperType SuperType);
    boolean isBooleanCompatible();
    boolean isStringCompatible();
    boolean isIntegerCompatible();
}
