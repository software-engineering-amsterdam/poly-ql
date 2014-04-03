/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.literals;

import java.util.Map;
import softwareconstruction.types.BoolType;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class BoolLiteral implements Expression {

    boolean value;
    
    public BoolLiteral (Boolean value){
        this.value = value;
    }
    
    @Override
    public boolean checkType(Map<String, SuperType> memory) {
        return true;
    }

    @Override
    public SuperType getType(Map<String, SuperType> memory) {
        return new BoolType();
    }
    
}
