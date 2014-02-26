package ql.ast.statements;

import ql.ast.expressions.ExprInterface;
import ql.ast.statements.types.STBoolean;
import ql.ast.EInterfaceVisitor;

import java.util.List;

public class IfStat implements SInterface {
    private final ExprInterface expression;
    private final List<SInterface> ifStatements;
    
    public IfStat(ExprInterface expression, List<SInterface> ifStatements) {
    	this.expression = expression;
    	this.ifStatements = ifStatements;
    }

	@Override
	public void accept(EInterfaceVisitor visitor) {
		//visitor.visit(this);
	}

	@Override
	public STBoolean getStatementType() {
		return new STBoolean();
	}
	
	public ExprInterface getExpression() {
		return this.expression;
	}
	
	public List<SInterface> getIfStatements() {
		return this.ifStatements;
	}
	
}