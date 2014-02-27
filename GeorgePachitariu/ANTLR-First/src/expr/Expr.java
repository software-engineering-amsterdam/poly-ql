package expr;

import typeChecker.ASTVisitor;

public abstract class Expr {

	@Override
	public boolean equals(Object obj) {
			return false;
	}
	
	public abstract void accept(ASTVisitor visitor);
}
