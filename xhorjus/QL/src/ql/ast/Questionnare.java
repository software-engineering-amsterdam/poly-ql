package ql.ast;
import java.util.List;

import ql.ast.statement.StatementInterface;

/**
 * Questionnare class, containing a list of statements
 */
public class Questionnare implements ElementInterface {
	private String id;
	private List<StatementInterface> statements;
	
	public Questionnare(String id, List<StatementInterface> statements) {
		this.id = id;
		this.statements = statements;
	}
	
	public String getID() { 
		return this.id; 
	}
	
	public List<StatementInterface> getStatements() { 
		return this.statements; 
	}
	
	@Override 
	public void accept(ElementInterfaceVisitor visitor) {
		for(ElementInterface statement : this.statements) {
			statement.accept(visitor);
		}
		
		visitor.visit(this);
	}
}
