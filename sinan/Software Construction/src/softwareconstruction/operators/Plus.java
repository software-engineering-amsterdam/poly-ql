/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.operators;

import java.util.Map;
import softwareconstruction.literals.Expression;
import softwareconstruction.types.IntType;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class Plus implements Expression {
    
    private final Expression leftNode;
    private final Expression rightNode;
    
    public Plus(Expression leftNode, Expression rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public boolean checkType(Map<String, SuperType> memory) {
        if(!leftNode.checkType(memory)){
            return false;
        }
        if(!rightNode.checkType(memory)){
            return false;
        }
        
        if(leftNode.getType(memory).isIntegerCompatible()){
             System.out.println("Left node is compatible");
        } else {
            System.out.println("Left node is NOT compatible - TERMINATING!");
            return false;
        }
        
        if(rightNode.getType(memory).isIntegerCompatible()) {
               System.out.println("Right node is compatible");
        } else {
            System.out.println("Right node is NOT compatible - TERMINATING!");
            return false;
        }
        return true;
    }

    @Override
    public SuperType getType(Map<String, SuperType> memory) {
        return new IntType();
    }
    
}
