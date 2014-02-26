package ql.ast.statement;

import ql.ast.type.TypeInterface;
import ql.ast.type.TypeMoney;

public class StatementMoney implements StatementTypeInterface {
	public StatementMoney() { }

	@Override
	public TypeInterface getType() {
		return new TypeMoney();
	}
	
	@Override
	public String toStr() {
		return "money";
	}
	
}