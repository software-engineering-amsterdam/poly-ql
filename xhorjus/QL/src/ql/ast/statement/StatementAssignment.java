package ql.ast.statement;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.statement.StatementTypeInterface;

/**
 * Class for assignment statements.
 * An assignment consists of a question ID, its contents and a type.
 */
public class StatementAssignment implements StatementInterface, StatementAssignmentInterface {
	private String ID;
	private String content;
	private StatementTypeInterface type;
	
	/* Constructor */
	public StatementAssignment(String ID, String content, StatementTypeInterface statementTypeInterface) {
		this.ID = ID;
		this.content = content;
		this.type = statementTypeInterface;
	}

	/* Accept visit */
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}

	/* Return ID */
	public String getID() {
		return this.ID;
	}
	
	/* Return contents */
	public String getContent() {
		return this.content;
	}
	
	/* Return type */
	@Override
	public StatementTypeInterface getType() {
		return this.type;
	}
	
}