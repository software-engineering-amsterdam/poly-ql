package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.TypeStmtVisitor;

public class CheckExpressions {
	
	private Form form;
	private TypeStmtVisitor sv;
	private List<String> errors;
	
	public CheckExpressions(Form form, Map<String, Type> symbolTable){
		this.form = form;
		this.sv = new TypeStmtVisitor(symbolTable);
		this.errors = new ArrayList<String>();
	}
	
	public List<String> getTypeErrors(){
		form.getBlock().accept(sv);
		if(sv.hasErrors()){
			errors.addAll(sv.getErrors());
		}
		return errors;
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
}
