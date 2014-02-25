package ql.ast.form;

import java.util.List;

import ql.ast.expr.ExprType.Ident;

public class Form {
	
	private final Ident id;
	private List<FormItems> formItems;
	
	public Form(Ident id, List<FormItems> formItems){
		this.id = id;
		this.formItems = formItems;
	}
	
	public List<FormItems> getFormItems() {
		return formItems;
	}
}
