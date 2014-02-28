package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.UndefinedQuestionStmtVisitor;

public class CheckUndefinedQuestion {
	
	private Form form;
	private UndefinedQuestionStmtVisitor sv;
	private List<String> errors;
	
	public CheckUndefinedQuestion(Form form, Map<String, Type> symbolTable){
		this.form = form;
		this.sv = new UndefinedQuestionStmtVisitor(symbolTable);
		this.errors = new ArrayList<String>();
	}
	
	public List<String> getUndefinedQuestions(){
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
