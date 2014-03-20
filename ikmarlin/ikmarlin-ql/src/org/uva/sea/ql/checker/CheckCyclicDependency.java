package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.exception.error.CyclicDependencyError;
import org.uva.sea.ql.checker.exception.error.Error;
import org.uva.sea.ql.checker.helper.Dependency;
import org.uva.sea.ql.checker.visitor.StmtVisitorDependencies;

public class CheckCyclicDependency {
	
	private List<Dependency> dependencies;
	private List<Error> errors;

	public CheckCyclicDependency(Form form){
		StmtVisitorDependencies sv = new StmtVisitorDependencies(form);
		dependencies = sv.getDependencies();
		errors = new ArrayList<Error>();
	}
	
	public List<Error> getCyclicDependencies(){
		for(Dependency original : dependencies){
			Dependency flipped = new Dependency(original);
			flipped.flip();
			for(Dependency control : dependencies){
				if(control.equals(flipped)){
					errors.add(new CyclicDependencyError(original));
				}
			}
		}
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<Error> getErrors() {
		return errors;
	}
	
}