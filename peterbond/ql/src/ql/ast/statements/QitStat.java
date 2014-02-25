package ql.ast.statements;

import ql.ast.statements.types.STInterface;
import ql.ast.EInterfaceVisitor;

public class QitStat implements SInterface, QitStatInterface {
    private final String id;
    private final String question;
    private final STInterface statementType;

    /**
     * Constructor
     */
    public QitStat(String id, String question, STInterface statementType)
    {
        this.id = id;
        this.question = question;
        this.statementType = statementType;
    }
    
	@Override
	public void accept(EInterfaceVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public STInterface getStatementType() {
		return this.statementType;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getQuestion() {
		return this.question;
	}
}
