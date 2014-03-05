package ql.ast;

import java.util.ArrayList;

/**
 * Questionnare class: contains a list of Forms.
 */
public class Questionnare {
	private ArrayList<Form> forms;
	
	/* Constructor */
	public Questionnare() {
		this.forms = new ArrayList<Form>();
	}
	
	/* Add a form */
	public void add(Form form) {
		this.forms.add(form);
	}
	
	/* Get all forms */
	public ArrayList<Form> getForms() {
		return this.forms;
	}
	
	/* Get a form */
	public Form getForm(int i) {
		return this.forms.get(i);
	}
}
