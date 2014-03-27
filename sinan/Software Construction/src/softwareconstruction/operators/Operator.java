/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.operators;

import softwareconstruction.literals.Expression;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public interface Operator extends Expression{
    public boolean isTypeCompatible(SuperType SuperType);
}
