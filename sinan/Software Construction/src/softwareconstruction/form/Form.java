/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction.form;

import java.util.ArrayList;
import java.util.List;
import softwareconstruction.questions.Question;
import softwareconstruction.questions.QuestionInterface;

/**
 *
 * @author Sinan
 */
public class Form {

    public List<QuestionInterface> itemlist = new ArrayList();
    private String formName;

    public Form(ArrayList form, String formName) {
        this.itemlist = form;
        this.formName = formName;
    }
    
    public Form() {
    }

    public void addQuestion(QuestionInterface object) {
        itemlist.add(object);
    }
    
    /**
     * @return the form
     */
    public List<QuestionInterface> getItems() {
        return itemlist;
    }

    /**
     * @param itemlist the form to set
     */
    public void setForm(ArrayList itemlist) {
        this.itemlist = itemlist;
    }

    /**
     * @return the formName
     */
    public String getFormName() {
        return formName;
    }

    /**
     * @param formName the formName to set
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }
}
