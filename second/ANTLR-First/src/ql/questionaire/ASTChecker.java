package ql.questionaire;

import ql.ast.checker.BooleanConditions;
import ql.ast.checker.CyclicDependencies;
import ql.ast.checker.DuplicateLabels;
import ql.ast.checker.DuplicatedIdentifier;
import ql.ast.checker.InvalidTypeOperands;
import ql.ast.checker.UndefinedIdentifier;
import ql.ast.node.syntactic.Form;
import ql.main.ASTCheckerError;

public class ASTChecker {

	public static void check(Form tree) throws ASTCheckerError {

		String errors=new String();
		errors=concatIfNotNull(errors, new CyclicDependencies().check(tree));	

		String err=new UndefinedIdentifier().check(tree);
		if(err != null)
			throw new ASTCheckerError(err + errors);

		errors=concatIfNotNull(errors, new DuplicatedIdentifier().check(tree));		
		errors=concatIfNotNull(errors, new BooleanConditions().check(tree));
		errors=concatIfNotNull(errors, new InvalidTypeOperands().check(tree));
		new DuplicateLabels().check(tree);
		if(!errors.isEmpty()) {
			throw new ASTCheckerError(errors);
		}
	}

	private static String concatIfNotNull(String errors, String check) {
		if(check!=null) {
			return errors+check;
		}
		else {
			return errors;
		}
	}
}
