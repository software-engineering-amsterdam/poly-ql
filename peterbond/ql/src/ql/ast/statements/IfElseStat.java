package ql.ast.statements;

import ql.ast.expressions.ExprInterface;
import ql.ast.statements.types.STBoolean;
import ql.ast.EInterfaceVisitor;

import java.util.List;

public class IfElseStat implements SInterface {
    private final ExprInterface expression;
    private final List<SInterface> ifStatements;
    private final List<SInterface> elseStatements;
    
    public IfElseStat(ExprInterface expression,
    		      List<SInterface> ifStatements,
    		      List<SInterface> elseStatements) {
    	this.expression = expression;
    	this.ifStatements = ifStatements;
    	this.elseStatements = elseStatements;
    }


	@Override
	public void accept(EInterfaceVisitor visitor) {
		visitor.visit(this);
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
	
	public List<SInterface> getElseStatements() {
		return this.elseStatements;
	}
	
}