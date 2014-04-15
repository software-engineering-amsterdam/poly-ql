package expr.unary;

import java.util.Map;

import ast.Visitor;
import ast.type.Inttype;
import ast.type.Type;
import expr.Expr;
import expr.Ident;

public class Pos extends Unaryexpr{

	public Pos(Expr expr) {
		super(expr);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		return new Inttype();
	}
}