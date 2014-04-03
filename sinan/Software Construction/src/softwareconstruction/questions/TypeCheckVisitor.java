/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareconstruction.questions;

import java.util.HashMap;
import java.util.Map;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class TypeCheckVisitor implements Visitor {

    Map<String, SuperType> memory = new HashMap();    
    
    @Override
    public void visit(Question question) {
        System.out.println(question.getQuestionContent());
        memory.put(question.getQuestionName(), question.getQuestionType());
    }

    @Override
    public void visit(ConditionalQuestion cq) {
        System.out.println(cq.getExpression().checkType(memory));
    }
    
}
