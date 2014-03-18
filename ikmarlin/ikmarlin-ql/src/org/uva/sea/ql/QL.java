package org.uva.sea.ql;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.SemanticChecker;
import org.uva.sea.ql.checker.error.Error;
import org.uva.sea.ql.checker.warning.Warning;

public class QL {

	public static void main(String[] args) {
		Compiler compiler = new Compiler("C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\House.ql");
		Form form = compiler.compile();
		if (compiler.hasErrors()) {
			for (String e : compiler.getAllErrors()) {
				System.err.println(e);
			}
		} else {
			SemanticChecker checker = new SemanticChecker(form);
			if(checker.hasSemanticErrors()){
				for(Warning wrn : checker.getWarnings()){
					System.out.println(wrn.getMessage());
				}
				for(Error err : checker.getErrors()){
					System.err.println(err.getMessage());
				}
			}
		}
	}

}
