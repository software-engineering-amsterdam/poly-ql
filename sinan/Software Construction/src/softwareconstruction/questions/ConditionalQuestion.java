/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction.questions;

import java.util.ArrayList;

/**
 *
 * @author Sinan
 */
public class ConditionalQuestion {
    
    private ArrayList expressions = new ArrayList();
    private ArrayList questions = new ArrayList();

    public ConditionalQuestion() {
    }

    public void addQuestion(Object o) {
        questions.add(o);
    }
    
    public void addExpression(Object o) {
        expressions.add(o);
        System.out.println("Added expression: "+o.toString());
    }
   
    public ArrayList getConditionalQuestions(){
        return questions;
    }
    
    
    
}
