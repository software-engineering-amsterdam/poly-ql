package org.uva.sea.ql.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;
import org.uva.sea.ql.interpreter.value.Undefined;
import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ExprEvaluator;

public class Results implements IStmtVisitor {
	
	private Map<String, Value<?>> values;
	
	public Results(){
		values = new LinkedHashMap<String, Value<?>>();
	}
	
	public void setValue(String ident, Value<?> value) {
		values.put(ident, value);
	}

	public Map<String, Value<?>> getValues() {
		return values;
	}

	public void fixResults(Form form) {
		form.getBlock().accept(this);
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
		if(!values.containsKey(stmt.getIdent().getName())){
			setValue(stmt.getIdent().getName(), new Undefined().parse(stmt.getType()));
		}
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		Value<?> computation = stmt.getComputation().accept(new ExprEvaluator(values));
		if(computation.getValue() != null){
			setValue(stmt.getIdent().getName(), computation);
		}
	}

	@Override
	public void visit(IfThenStatement stmt) {
		Value<?> condition = stmt.getCondition().accept(new ExprEvaluator(values));
		if(condition.getValue().equals(true)){
			stmt.getBody().accept(this);
		}
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		Value<?> condition = stmt.getCondition().accept(new ExprEvaluator(values));
		if(condition.getValue().equals(true)){
			stmt.getBody().accept(this);
		}
		if(condition.getValue().equals(false)){
			stmt.getBody().accept(this);
		}
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s : stmt.getStatements()){
			s.accept(this);
		}
	}
	
}