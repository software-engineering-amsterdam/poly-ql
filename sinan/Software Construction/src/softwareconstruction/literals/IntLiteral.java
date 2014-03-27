/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.literals;

import softwareconstruction.types.IntType;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class IntLiteral implements Expression{
    
    int value;
    
    public IntLiteral(Integer value){
        this.value = value;
    }
    
    @Override
    public boolean checkType(SuperType S) {
        return true;
    }

    @Override
    public SuperType getType() {
        return new IntType();
    }
    
}
