package ql.ast.node.syntactic;

import java.util.List;

import ql.ast.node.Expression;
import ql.ast.visitor.ASTVisitor;

public class IfElseBlock extends IfBlock {
	private List<Statement> elseStatements;

	public IfElseBlock(Expression condition, List<Statement> thenStatements, List<Statement> elseStatements) {
		super(condition, thenStatements);
		this.elseStatements=elseStatements;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IfElseBlock))
			return false;
		IfElseBlock ifBlock=(IfElseBlock) obj;
		return condition.equals(ifBlock.condition) &&
				thenStatements.equals(ifBlock.thenStatements) &&
				elseStatements.equals(ifBlock.elseStatements);
	}


	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(condition, thenStatements, elseStatements);
	}

	@Override
	public String toString() {
		String str=super.toString();

		if(elseStatements.size()>0) {
			str+= " else { \n";
			for(Statement s: elseStatements)
				str+=s.toString() + "\n";
			str+= "} \n";
		}
		return str;
	}
}
