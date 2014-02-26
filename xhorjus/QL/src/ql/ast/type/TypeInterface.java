package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

/**
 * Type interface
 */
public interface TypeInterface {
	public String toStr();
	
	public Boolean compatibleWith(StatementBoolean type);
	public Boolean compatibleWith(StatementMoney type);
	public Boolean compatibleWith(StatementString type);
}
