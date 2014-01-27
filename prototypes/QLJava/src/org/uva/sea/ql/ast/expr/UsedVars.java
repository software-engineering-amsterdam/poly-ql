package org.uva.sea.ql.ast.expr;

import java.util.HashSet;
import java.util.Set;

public class UsedVars extends TopDown {
	public static Set<Ident> usedVars(Expr expr) {
		UsedVars u = new UsedVars();
		expr.accept(u);
		return u.variables;
	}
	
	private Set<Ident> variables = new HashSet<Ident>();
	
	private UsedVars() {
	}
	
	@Override
	public Void visit(Ident var) {
		variables.add(var);
		return null;
	}

}
