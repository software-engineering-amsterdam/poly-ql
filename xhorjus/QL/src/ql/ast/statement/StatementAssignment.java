package ql.ast.statement;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.statement.StatementTypeInterface;

public class StatementAssignment implements StatementInterface {
	private String ID;
	private String content;
	private StatementTypeInterface type;
	
	public StatementAssignment(String ID, String content, StatementTypeInterface statementTypeInterface) {
		this.ID = ID;
		this.content = content;
		this.type = statementTypeInterface;
	}

	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}

	public String getID() {
		return this.ID;
	}
	
	public String getContent() {
		return this.content;
	}
	
	@Override
	public StatementTypeInterface getType() {
		return this.type;
	}
	
}