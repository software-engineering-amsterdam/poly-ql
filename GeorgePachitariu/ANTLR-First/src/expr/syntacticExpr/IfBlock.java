package expr.syntacticExpr;

import java.util.LinkedList;
import java.util.List;

import expr.Expression;
import typeChecker.ASTVisitor;


public class IfBlock extends Statement {
	private Expression condition;
	private List<Statement> thenStatements;
	private List<Statement> elseStatements;

	public IfBlock(Expression condition, List<Statement> thenStatements) {
		super();
		this.condition=condition;
		this.thenStatements=thenStatements;
		this.elseStatements=new LinkedList<>();
	}

	public IfBlock(Expression condition, List<Statement> thenStatements, List<Statement> elseStatements) {
		super();
		this.condition=condition;
		this.thenStatements=thenStatements;
		this.elseStatements=elseStatements;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IfBlock))
			return false;
		IfBlock ifBlock=(IfBlock) obj;
		return this.condition.equals(ifBlock.condition) &&
				this.thenStatements.equals(ifBlock.thenStatements) &&
				  this.elseStatements.equals(ifBlock.elseStatements);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.condition.accept(visitor);
		for(Statement s : this.thenStatements)
			s.accept(visitor);
		for(Statement s : this.elseStatements)
			s.accept(visitor);
	}
	
	public boolean isExpressionBoolean() { 
		return this.condition.getType().isBoolean();
	}
	
	@Override
	public String toString() {
		String str = "if(" + this.condition.toString() + ") \n {";
		for(Statement s: thenStatements)
			str+=s.toString() + "\n";
		str+= "} \n";
		
		if(this.elseStatements.size()>0) {
			str+= " else { \n";
			for(Statement s: elseStatements)
				str+=s.toString() + "\n";
			str+= "} \n";
		}
		return str;
	}

	public Expression getCondition() {
		return this.condition;
	}
}
