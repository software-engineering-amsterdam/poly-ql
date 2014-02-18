package ast.expr.unExpression;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.types.IntType;
import ast.types.MoneyType;
import ast.types.Types;

public class Pos extends UnExpr{
	public Pos(Expr operand){
		super(operand);		
	}

	@Override
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
