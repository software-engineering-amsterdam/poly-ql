package gui;

import ast.statement.Form;

public class TypeCheckedForm {
	
	private Form form;
	private boolean success;
	private String errors;

	public TypeCheckedForm(Form form, boolean success, String errors) {
		this.form = form;
		this.success = success;
		this.errors = errors;
	}

	public Form getForm() {
		return form;
	}

	public boolean isSucces() {
		return success;
	}

	public String getErrors() {
		return errors;
	}

}
