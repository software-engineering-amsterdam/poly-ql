/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.types;

import java.util.Map;
import softwareconstruction.literals.Expression;


/**
 *
 * @author Sinan
 */
public class Variable implements Expression {

    String name;
    
    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public boolean checkType(Map<String, SuperType> memory) {
        if(memory.containsKey(name)){
            return true;
        }
        return false;
    }

    @Override
    public SuperType getType(Map<String, SuperType> memory) {
        if(memory.containsKey(name)){
            return memory.get(name);
        }
        return null;
    }
    
}
