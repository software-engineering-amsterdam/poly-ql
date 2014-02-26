package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

public class TypeMoney implements TypeInterface {
	public TypeMoney() { }

	@Override
	public Boolean compatibleWith(StatementBoolean type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean compatibleWith(StatementMoney type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean compatibleWith(StatementString type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//@Override 
	//public Boolean compatibleWith()
}