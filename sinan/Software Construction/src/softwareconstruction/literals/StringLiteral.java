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
public class StringLiteral implements Expression{

    String value;
    
    public StringLiteral(String value){
        this.value = value;
    }
    
    @Override
    public boolean checkType(SuperType S) {
        return true;
    }

    @Override
    public SuperType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
