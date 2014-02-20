package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;

public class FormChecker implements FormVisitor<Boolean> {
	
	private final Map<Ident, Type> typeEnv;
	private final List<String> errors;
	
	private FormChecker(Map<Ident, Type> env, List<String> errors) {
		this.typeEnv = env;
		this.errors = errors;
	}
	
	public static boolean check(Form form) {
		return FormChecker.check(form, new HashMap<Ident, Type>(), new ArrayList<String>());
	}
	
	public static boolean check(Form form, Map<Ident, Type> env, List<String> errors)
	{
		FormChecker checker = new FormChecker(env, errors);
		return form.accept(checker);
	}
	
	@Override
	public Boolean visit(Form form) {
		boolean result = true;
		for (Stat s : form.getBody().getStats()) {
			if(!s.accept(this)) {
				result = false;
			}
		}
		
		// Check for cyclic dependencies  is not neccesary because questions can only
		// refer to already defined questions.
		// if (x) { y: "Y?" boolean }
		// if (y) { x: "X?" boolean }
		// will not validate because question x isn't defined 
		// when it is used in the condition of the first  if statement.
		
		return result;
	}
	
	@Override
	public Boolean visit(Question question) {
		boolean result = true;
		if(this.typeEnv.containsKey(question.getName())) {
			this.errors.add(String.format("Question identifier '%s' already defined in question %s", 
										   question.getName(), question.getLabel()));
			result = false;
		}
		else {
			this.typeEnv.put(question.getName(),question.getType());
		}
		
		return result;
	}

	@Override
	public Boolean visit(Computed computed) {
		boolean result = ExprChecker.check(computed.getExpr(), this.typeEnv, this.errors);
		if(this.typeEnv.containsKey(computed.getName())) {
			this.errors.add(String.format("Question identifier '%s' already defined in computed question %s",
										   computed.getName(), computed.getLabel()));
			result = false;
		}
		else {
			this.typeEnv.put(computed.getName(),computed.getType());
		}
		
		if(!computed.getExpr().typeOf(this.typeEnv).getClass().equals(computed.getType().getClass()))
		{
			this.errors.add(String.format("Type of expression '%s' of computed question '%s' is defined as type '%s' " +
										  "but evaluated to be of type '%s'",
										   computed.getExpr(), computed.getName(), computed.getType(),
										   computed.getExpr().typeOf(this.typeEnv)));
			result = false;
		}
		
		return result;
	}
	
	@Override
	public Boolean visit(IfThen ifStatement) {
		boolean result = ExprChecker.check(ifStatement.getCond(), this.typeEnv, this.errors);
		
		if(!ifStatement.getCond().typeOf(this.typeEnv).isCompatibleTo(new Bool())) {
			result = false;
			this.errors.add(String.format("Expression of if statement isn't compatible to type boolean: %s is of type %s",
										   ifStatement.getCond(), ifStatement.getCond().typeOf(this.typeEnv)));
		}
		
		if(!ifStatement.getBody().accept(this)) {
			result = false;
		}
		return result;
	}

	@Override
	public Boolean visit(IfThenElse elseStatement) {
		boolean result = ExprChecker.check(elseStatement.getCond(), this.typeEnv, this.errors);
		
		if(!elseStatement.getCond().typeOf(this.typeEnv).isCompatibleTo(new Bool())) {
			result = false;
			this.errors.add(String.format("Expression of if-else statement isn't compatible to type boolean: %s is of type %s",
										   elseStatement.getCond(), elseStatement.getCond().typeOf(this.typeEnv)));
		}
		
		if(!elseStatement.getBody().accept(this)) {
			result = false;
		}
		if(!elseStatement.getElseBody().accept(this)) {
			result = false;
		}
		return result;
	}
	
	@Override
	public Boolean visit(Block stat) {
		boolean result = true;
		
		for (Stat s : stat.getStats()) {
			if(!s.accept(this)) {
				result = false;
			}
		}
		
		return result;
	}

	public List<String> getErrors() {
		return errors;
	}
}
