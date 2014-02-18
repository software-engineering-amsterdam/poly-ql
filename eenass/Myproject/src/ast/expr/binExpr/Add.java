package ast.expr.binExpr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.types.*;

public class Add extends BinExpr{

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symb) {
		if(typeof(symb).isCompatableToInt()){
			return new IntType();
		}	
		else if(typeof(symb).isCompatableToMoney()){
			return new MoneyType();
		}
		return null;
	}

}
