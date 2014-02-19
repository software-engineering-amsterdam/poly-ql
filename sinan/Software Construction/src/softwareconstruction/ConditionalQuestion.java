/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction;

import java.util.ArrayList;

/**
 *
 * @author Sinan
 */
public class ConditionalQuestion {

    private ArrayList questions = new ArrayList();

    public ConditionalQuestion() {
    }

    public void add(Object o) {
        questions.add(o);
    }
   
    public ArrayList getConditionalQuestions(){
        return questions;
    }
    
}
