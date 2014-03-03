package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.checker.helper.Dependency;

public class DependencyCollectorStmtVisitor implements IStmtVisitor {
	
	private DependencyCollectorExprVisitor ev;
	private List<Dependency> dependencies;
	private List<Ident> tempMasters;
	private List<String> tempSlaves;
	private boolean isConditional = false;
	
	public DependencyCollectorStmtVisitor(){
		this.dependencies = new ArrayList<Dependency>();
		this.ev = new DependencyCollectorExprVisitor();
	}
	
	public List<Dependency> getDependencies(){
		return dependencies;
	}
	
	private void addTempSlave(Question question){
		//Prevent the same question from being added twice.
		//Possible with ifThenElse...
		if(!tempSlaves.contains(question.getIdent().getName())){
			tempSlaves.add(question.getIdent().getName());
		}
	}
	
	private void addDependencies(ConditionalQuestion question){
		ev.resetVariables();
		tempMasters = new ArrayList<Ident>(question.getCondition().accept(ev));
		for(Ident master : tempMasters){
			for(String slave : tempSlaves){
				Dependency d = new Dependency(master.getName(), slave);
				dependencies.add(d);
			}
		}
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
		if(isConditional){
			addTempSlave(stmt);
		}
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		if(isConditional){
			addTempSlave(stmt);
		}
	}

	@Override
	public void visit(IfThenStatement stmt) {
		isConditional = true;
		tempSlaves = new ArrayList<String>();
		stmt.getBody().accept(this);
		addDependencies(stmt);
		isConditional = false;
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		isConditional = true;
		stmt.getBody().accept(this);
		stmt.getElseBlock().accept(this);
		addDependencies(stmt);
		isConditional = false;
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s:stmt.getStatements()){
			s.accept(this);
		}
	}
	
}
