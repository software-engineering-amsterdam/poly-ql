package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.types.Bool;

//Check for cyclic dependencies  is not neccesary because questions can only
// refer to already defined questions.
// if (x) { y: "Y?" boolean }
// if (y) { x: "X?" boolean }
// will not validate because question x isn't defined 
// when it is used in the condition of the first  if statement.
public class FormChecker implements FormVisitor<Boolean> {
	
	private final TypeEnvironment typeEnv;
	private final List<String> errors;
	
	private FormChecker(TypeEnvironment env, List<String> errors) {
		this.typeEnv = env;
		this.errors = errors;
	}
	
	public static boolean check(Form form) {
		return FormChecker.check(form, new TypeEnvironment(), new ArrayList<String>());
	}
	
	public static boolean check(Form form, TypeEnvironment env, List<String> errors)
	{
		return form.accept(new FormChecker(env, errors));
	}
	
	@Override
	public Boolean visit(Form form) {
		boolean result = true;
		for (Stat s : form.getBody().getStats()) {
			result &= s.accept(this);
		}
		
		return result;
	}
	
	@Override
	public Boolean visit(Question question) {
		if (this.typeEnv.isIdentDefined(question.getName())) {
			this.errors.add(String.format("Question identifier '%s' already defined in question %s", 
										   question.getName(), question.getLabel()));
			return false;
		}
		else {
			this.typeEnv.setTypeOfIdent(question.getName(), question.getType());
		}
		
		return true;
	}

	@Override
	public Boolean visit(Computed computed) {
		if (this.typeEnv.isIdentDefined(computed.getName())) {
			this.errors.add(String.format("Question identifier '%s' already defined in computed question %s",
										   computed.getName(), computed.getLabel()));
			return false;
		}
		else {
			this.typeEnv.setTypeOfIdent(computed.getName(), computed.getType());
		}
		
		if (!ExprChecker.check(computed.getExpr(), this.typeEnv, this.errors)) {
			return false;
		}
		
		if (!computed.getExpr().typeOf(this.typeEnv).getClass().equals(computed.getType().getClass()))
		{
			this.errors.add(String.format("Type of expression '%s' of computed question '%s' is defined as type '%s' " +
										  "but evaluated to be of type '%s'",
										   computed.getExpr(), computed.getName(), computed.getType(),
										   computed.getExpr().typeOf(this.typeEnv)));
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(IfThen ifStatement) {
		boolean result = true;
		if (!ifStatement.getCond().typeOf(this.typeEnv).isCompatibleTo(new Bool())) {
			this.errors.add(String.format("Expression of if statement isn't compatible to type boolean: %s is of type %s",
										   ifStatement.getCond(), ifStatement.getCond().typeOf(this.typeEnv)));
			result = false;
		}
		else {
			result = ExprChecker.check(ifStatement.getCond(), this.typeEnv, this.errors);
		}
		
		result &= ifStatement.getBody().accept(this);
		
		return result;
	}

	@Override
	public Boolean visit(IfThenElse elseStatement) {
		boolean result = true;
		if (!elseStatement.getCond().typeOf(this.typeEnv).isCompatibleTo(new Bool())) {
			this.errors.add(String.format("Expression of if-else statement isn't compatible to type boolean: %s is of type %s",
										   elseStatement.getCond(), elseStatement.getCond().typeOf(this.typeEnv)));
			result = false;
		}
		else {
			result = ExprChecker.check(elseStatement.getCond(), this.typeEnv, this.errors);
		}
		
		result &= elseStatement.getBody().accept(this);
		result &= elseStatement.getElseBody().accept(this);
		
		return result;
	}
	
	@Override
	public Boolean visit(Block stat) {
		boolean result = true;
		
		for (Stat s : stat.getStats()) {
			result &= s.accept(this);
		}
		
		return result;
	}

	public List<String> getErrors() {
		return errors;
	}
}
