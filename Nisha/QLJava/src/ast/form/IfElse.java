package ast.form;


import ast.Visitor;
import expr.Expr;


public class IfElse extends Ifstate{
	
	private final StatementList statement1 ;

	public IfElse(StatementList statements, Expr expr,StatementList statement1 ) {
		super(statements, expr);
		this.statement1= statement1;
	}


	public StatementList getStatement1() {
		return statement1;
	}

	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}