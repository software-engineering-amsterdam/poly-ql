/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.literals;

import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public interface Expression {
    boolean checkType(SuperType S);
}
