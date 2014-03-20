package org.uva.sea.ql.checker.exception.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public class IncompatibleTypesError extends IllegalTypeError {
	
	private static final long serialVersionUID = 1L;
	
	private Expr exprTwo;
	private Type typeTwo;
	
	public IncompatibleTypesError(Expr exprOne, Type typeOne, Expr exprTwo, Type typeTwo) {
		super(exprOne, typeOne);
		this.exprTwo = exprTwo;
		this.typeTwo = typeTwo;
	}
	
	@Override
	public String getMessage(){
		return "<< "+expr+" ("+given+") >> and << "+this.exprTwo+" ("+this.typeTwo+") >> are incompatible.";
	}

}
