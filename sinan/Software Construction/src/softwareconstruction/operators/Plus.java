/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.operators;

import softwareconstruction.literals.Expression;
import softwareconstruction.literals.LeftNode;
import softwareconstruction.literals.RightNode;
import softwareconstruction.types.IntType;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class Plus implements Operator {
    
    private final LeftNode leftNode;
    private final RightNode rightNode;
    
    public Plus(LeftNode leftNode, RightNode rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    
    @Override
    public boolean isTypeCompatible(SuperType supertype) {
        return supertype.isIntegerCompatible();
    }

    @Override
    public boolean checkType(SuperType supertype) {
//        
//        if(!rightNode.checkType(supertype)){
//            return false;
//        }
//        
//        if(isTypeCompatible(leftNode.getType())){
//            System.out.println("Left node is compatible");
//        } else {
//            return false;
//        }
//        
//        if(isTypeCompatible(rightNode.getType())){
//            System.out.println("Right node is compatible");
//        } else {
//            return false;
//        }
        
        return true;
    }

    @Override
    public SuperType getType() {
        return new IntType();
    }
    
}
