package ql.ast.statements;

import ql.ast.expressions.ExprInterface;
import ql.ast.statements.types.STInterface;
import ql.ast.EInterfaceVisitor;


public class QitExprStat implements QitStatInterface, SInterface {
    private final String id;
    private final String question;
    private final STInterface statementType;
    private final ExprInterface expression;
    
    public QitExprStat(String id, 
    		           String question, 
    		           STInterface statementType, 
    		           ExprInterface expression) {
    	this.id = id;
    	this.question = question;
    	this.statementType = statementType;
    	this.expression = expression;
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

	public ExprInterface getExpression() {
		return this.expression;
	}
}
