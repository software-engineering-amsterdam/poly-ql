package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.error.CyclicDependencyError;
import org.uva.sea.ql.checker.helper.Dependency;
import org.uva.sea.ql.checker.visitor.DependencyCollectorStmtVisitor;

public class CheckCyclicDepency {
	
	private List<Dependency> dependencies;
	private List<String> errors;

	public CheckCyclicDepency(Form form){
		DependencyCollectorStmtVisitor sv = new DependencyCollectorStmtVisitor();
		form.getBlock().accept(sv);
		dependencies = sv.getDependencies();
		errors = new ArrayList<String>();
	}
	
	public List<String> getCyclicDependencies(){
		for(Dependency original : dependencies){
			Dependency flipped = new Dependency(original);
			flipped.flip();
			for(Dependency control : dependencies){
				if(control.equals(flipped)){
					errors.add(CyclicDependencyError.getMessage(original));
				}
			}
		}
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<String> getErrors() {
		return errors;
	}

}