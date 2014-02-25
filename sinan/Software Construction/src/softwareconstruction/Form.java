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

    public ArrayList itemlist = new ArrayList();
    private String formName;

    public Form(ArrayList form, String formName) {
        this.itemlist = form;
        this.formName = formName;
    }
    
    public Form() {
    }

    public void addQuestion(Object object) {
        itemlist.add(object);
    }
    
    /**
     * @return the form
     */
    public List getItems() {
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
