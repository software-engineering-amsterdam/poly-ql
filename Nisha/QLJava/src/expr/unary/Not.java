package expr.unary;

import java.util.Map;

import ast.Visitor;
import ast.type.Booltype;
import ast.type.Type;
import expr.Expr;
import expr.Ident;

public class Not extends Unaryexpr{

	public Not(Expr expr) {
		super(expr);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		return new Booltype();
	}

	
}