import java.util.List;

/**
 * Questionnare class, containing a list of statements
 */
public class Questionnare implements ElementInterface {
	public String id;
	public List<StatementInterface> statements;
	
	@Override 
	public void accept(ElementInterfaceVisitor visitor) {
		for(ElementInterface statement : this.statements) {
			statement.accept(visitor);
		}
		
		visitor.visit(this);
	}
}
