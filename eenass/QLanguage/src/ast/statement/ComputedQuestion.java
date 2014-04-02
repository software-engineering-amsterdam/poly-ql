package ast.statement;

import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.literal.StrLiteral;
import ast.types.Type;
import ast.visitors.StatementVisitor;

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
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
