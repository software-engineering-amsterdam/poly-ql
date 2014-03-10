package ql.ast;
import java.util.List;

import ql.ast.statement.StatementInterface;

/**
 * Form class, containing a list of statements
 */
public class Form implements ElementInterface {
	private String id;
	private List<StatementInterface> statements;
	
	/* Constructor */
	public Form(String id, List<StatementInterface> statements) {
		this.id = id;
		this.statements = statements;
	}
	
	/* Return form name */
	public String getID() { 
		return this.id; 
	}
	
	/* Return form statements */
	public List<StatementInterface> getStatements() { 
		return this.statements; 
	}
	
	/* Accept visit: for each statement, also accept visit. */
	@Override 
	public void accept(ElementInterfaceVisitor visitor) {
		for(ElementInterface statement : this.statements) {
			statement.accept(visitor);
		}
		
		visitor.visit(this);
	}
	
	/* Amount of statements in this form */
	public int countStatements() {
		return this.statements.size();
	}
	
	/* Return a specific statement in this form */
	public StatementInterface getStatement(int i) {
		return this.statements.get(i);
	}
}
