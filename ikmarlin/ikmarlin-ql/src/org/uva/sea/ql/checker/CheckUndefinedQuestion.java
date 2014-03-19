package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.error.Error;
import org.uva.sea.ql.checker.error.UndefinedQuestion;
import org.uva.sea.ql.checker.visitor.ExprVisitorIdentifiers;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;

public class CheckUndefinedQuestion implements IStmtVisitor {
	
	private Map<String, Type> symbolTable;
	private List<Error> errors;
	
	public CheckUndefinedQuestion(Form form, Map<String, Type> symbolTable){
		this.symbolTable = symbolTable;
		this.errors = new ArrayList<Error>();
		form.getBlock().accept(this);
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<Error> getErrors(){
		return errors;
	}

	private void checkExpr(Expr ex) {
		Set<Ident> identifiers = ex.accept(new ExprVisitorIdentifiers());
		for(Ident ident :  identifiers){
			if(!symbolTable.containsKey(ident.getName())){
				errors.add(new UndefinedQuestion(ident));
			}
		}
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		checkExpr(stmt.getComputation());
	}

	@Override
	public void visit(IfThenStatement stmt) {
		checkExpr(stmt.getCondition());
		stmt.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		checkExpr(stmt.getCondition());
		stmt.getBody().accept(this);
		stmt.getElseBlock().accept(this);
	}

	@Override
	public void visit(Block stmt) {
		for (Stmt s : stmt.getStatements()) {
			s.accept(this);
		}
	}

}
