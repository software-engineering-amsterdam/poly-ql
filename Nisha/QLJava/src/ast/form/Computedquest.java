package ast.form;

import ast.Visitor;
import ast.literals.StrLiteral;
import ast.type.Type;
import expr.Expr;
import expr.Ident;

public class Computedquest extends Question {

	private final Expr expr;
	public Computedquest(Ident id, StrLiteral statement, Type type, Expr expr) {
		super(id,statement,type);
		this.expr= expr;
	}
	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
