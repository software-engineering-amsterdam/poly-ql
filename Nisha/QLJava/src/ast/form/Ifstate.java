package ast.form;


import ast.Visitor;
import expr.Expr;

public class Ifstate extends Block {

	private final Expr expr;
	
	public Ifstate(StatementList statements, Expr expr) {
		super(statements);
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}

	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}

}	