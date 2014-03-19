package nodeAST.syntactic;

import java.util.LinkedList;
import java.util.List;

import nodeAST.ASTNode;
import nodeAST.Expression;


import visitor.ASTVisitor;

public class IfElseBlock extends IfBlock {
	protected List<Statement> elseStatements;
	
	public IfElseBlock(Expression condition, List<Statement> thenStatements, List<Statement> elseStatements) {
		super(condition, thenStatements);
		this.elseStatements=elseStatements;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IfElseBlock))
			return false;
		IfElseBlock ifBlock=(IfElseBlock) obj;
		return this.condition.equals(ifBlock.condition) &&
				this.thenStatements.equals(ifBlock.thenStatements) &&
				this.elseStatements.equals(ifBlock.elseStatements);
	}


	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, this.condition, this.thenStatements, this.elseStatements);
	}
	
	@Override
	public String toString() {
		String str=super.toString();

		if(this.elseStatements.size()>0) {
			str+= " else { \n";
			for(Statement s: elseStatements)
				str+=s.toString() + "\n";
			str+= "} \n";
		}
		return str;
	}
}
