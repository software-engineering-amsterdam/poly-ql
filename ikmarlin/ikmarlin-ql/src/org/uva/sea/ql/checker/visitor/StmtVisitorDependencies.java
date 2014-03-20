package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.checker.helper.Dependency;

public class StmtVisitorDependencies implements IStmtVisitor {

	private boolean isConditional;
	private Map<Expr, Integer> conditionScope;
	private int depth;
	private List<Dependency> dependencies;

	public StmtVisitorDependencies(Form form) {
		depth = 0;
		conditionScope = new LinkedHashMap<Expr, Integer>();
		dependencies = new ArrayList<Dependency>();
		form.getBlock().accept(this);
	}
	
	public List<Dependency> getDependencies(){
		return dependencies;
	}

	public Map<String, List<String>> getDependencyMap(){
		 Map<String, List<String>> dependencyMap = new  HashMap<String, List<String>>();
		 List<String> dependents = null;
		 for(Dependency d : dependencies){
			 if(dependencyMap.containsKey(d.getX())){
				 dependents = dependencyMap.get(d.getX());
			 }else{
				 dependents = new ArrayList<String>();
			 }
			 dependents.add(d.getY());
			 dependencyMap.put(d.getX(), dependents);
		 }
		 return dependencyMap;
	}
	
	private void addDependencies(Set<Ident> masters, Question slave){
		if(masters != null){
			for(Ident ident : masters){
				Dependency dependency = new Dependency(ident.getName(), slave.getIdent().getName());
				dependencies.add(dependency);
			}
		}
	}
	
	private Expr getCondition(Question q) {
		int depthSought = depth;
		return getCondition(depthSought);
	}

	private Expr getCondition(ConditionalQuestion c) {
		int depthSought = depth -1;
		return getCondition(depthSought);
	}

	private Expr getCondition(int depthSought){
		Expr parent = null;
		List<Expr> reversed = new LinkedList<Expr>(conditionScope.keySet());
		Collections.reverse(reversed);
		for (Expr ex : reversed) {
			if (conditionScope.get(ex) == depthSought) {
				return ex;
			}
		}
		return parent;
	}

	private void visitQuestion(Question stmt){
		if (isConditional) {
			Set<Ident> masters = getCondition(stmt).accept(new ExprVisitorIdentifiers());
			addDependencies(masters, stmt);
		}
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
		visitQuestion(stmt);
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		visitQuestion(stmt);
		Set<Ident> masters = stmt.getComputation().accept(new ExprVisitorIdentifiers());
		addDependencies(masters, stmt);
	}

	@Override
	public void visit(IfThenStatement stmt) {
		Expr condition = stmt.getCondition();
		if (isConditional) {
			depth++;
			condition = new And(getCondition(stmt), condition);
			conditionScope.put(condition, depth);
			stmt.getBody().accept(this);
			depth--;
		} else {
			conditionScope.put(condition, depth);
			isConditional = true;
			stmt.getBody().accept(this);
			isConditional = false;
		}
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		Expr condition = stmt.getCondition();
		if (isConditional) {
			depth++;
			condition = new And(getCondition(stmt), condition);
			conditionScope.put(condition, depth);
			stmt.getBody().accept(this);
			stmt.getElseBlock().accept(this);
			depth--;
		} else {
			conditionScope.put(condition, depth);
			isConditional = true;
			stmt.getBody().accept(this);
			stmt.getElseBlock().accept(this);
			isConditional = false;
		}
	}

	@Override
	public void visit(Block stmt) {
		for (Stmt s : stmt.getStatements()) {
			s.accept(this);
		}
	}

}