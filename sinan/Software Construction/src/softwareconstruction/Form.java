/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinan
 */
public class Form {

    public ArrayList<Question> form = new ArrayList();
    public Question question;

    public Form(ArrayList form, Question question) {
        this.form = form;
        this.question = question;
    }
    
    public Form() {
    }

    public List addQuestion(Question question) {
        form.add(question);
        return form;
    }

    /**
     * @return the form
     */
    public List getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(ArrayList form) {
        this.form = form;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

}
