package ast.statement;

import ast.Visitor;
import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.literal.StrLiteral;
import ast.expr.types.Type;

public class ComputedQuestion extends Question{
	
	private final Expr expr;

	public ComputedQuestion(Identifier id, StrLiteral label, Type type, Expr expr) {
		super(id, label, type);
		this.expr = expr;
	}
	
	public Expr getExpr(){
		return expr;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
