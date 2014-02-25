package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Error;

public class CyclicStmtChecker implements StmtVisitor {
	
	private List<Dependancy> conditionalDependancies,computationalDependancies;
	private List<Dependancy> cyclic;
	private List<String> conditions;
	private CyclicExprChecker cec;
	private ArrayList<Error> errors;
	private boolean conditional = false;
	
	public CyclicStmtChecker() {
		conditionalDependancies = new ArrayList<Dependancy>();
		computationalDependancies = new ArrayList<Dependancy>();
		cyclic = new ArrayList<Dependancy>();
		conditions = new ArrayList<String>();
		cec = new CyclicExprChecker();
		errors = new ArrayList<Error>();
	}

	public CyclicExprChecker getExprChecker() {
		return cec;
	}

	public void setExprChecker(CyclicExprChecker cec) {
		this.cec = cec;
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public ArrayList<Error> getErrors() {
		return errors;
	}

	private void addError(String msg){
		errors.add(new Error(msg));
	}
	
	private void addDependancy(AnswerableQuestion dependant){
		if(!conditions.isEmpty()){
			for(String condition : conditions){
				conditionalDependancies.add(new Dependancy(dependant.getIdent().getName(), condition));
			}
		}
	}
	
	private void addDependancy(ComputedQuestion dependant){
		if(!conditions.isEmpty()){
			for(String condition : conditions){
				computationalDependancies.add(new Dependancy(dependant.getIdent().getName(), condition));
			}
		}
	}
	
	private void addDependancies(String dependant, List<String> idents){
		for(String ident : idents){
			computationalDependancies.add(new Dependancy(dependant, ident));
		}
		cec.resetDependancies();
	}
	
	public void cyclicCheck(Form form){
		visit(form);
		checkCyclicDependancies();
	}
	
	public void checkCyclicDependancies(){
		List<Dependancy> check = new ArrayList<Dependancy>();
		for(Dependancy con : conditionalDependancies){
			Dependancy flipped = new Dependancy(con.getY(), con.getX());
			check.add(flipped);
			for(Dependancy f : check){
				if(con.equals(f)){
					cyclic.add(con);
					addError("the question "+con.getX()+" and condition "+con.getY()+" depend on one another.");
					addError("the question "+f.getY()+" and condition "+f.getX()+" depend on one another.");
				}
			}
		}
		for(Dependancy com : computationalDependancies){
			Dependancy flipped = new Dependancy(com.getY(), com.getX());
			check.add(flipped);
			for(Dependancy f : check){
				if(com.equals(f)){
					cyclic.add(com);
					addError("the question "+com.getX()+" and the computation variable "+com.getY()+" refer to on one another.");
				}
			}
		}
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
		if(conditional){
			addDependancy(stmt);
		}
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		if(conditional){
			addDependancy(stmt);
		}
		stmt.getComputation().accept(cec);
		String dependant = stmt.getIdent().getName();
		addDependancies(dependant, cec.getDependancies());
	}

	@Override
	public void visit(ConditionalQuestion stmt) {
		conditional = true;
		stmt.getCondition().accept(cec);
		conditions = new ArrayList<String>(cec.getDependancies());
		cec.resetDependancies();
		stmt.getBody().accept(this);
		cec.resetDependancies();
		conditional = false;
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s:stmt.getStatements()){
			s.accept(this);
		}
	}

	@Override
	public void visit(Form stmt) {
		stmt.getBlock().accept(this);
	}

}
