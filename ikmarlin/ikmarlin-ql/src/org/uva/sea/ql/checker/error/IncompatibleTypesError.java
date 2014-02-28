package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public abstract class IncompatibleTypesError extends IllegalTypeError {
	
	public static String getMessage(Expr exprOne, Type typeOne, Expr exprTwo, Type typeTwo){
		return "<< "+exprOne.toString()+" ("+typeOne+") >> and << "+exprTwo.toString()+" ("+typeTwo+") >> are incompatible.";
	}

}
