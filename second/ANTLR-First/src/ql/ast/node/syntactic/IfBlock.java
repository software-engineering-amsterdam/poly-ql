package ql.ast.node.syntactic;

import java.util.List;

import ql.ast.node.Expression;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class IfBlock extends Statement {
	protected Expression condition;
	protected List<Statement> thenStatements;

	public IfBlock(Expression condition, List<Statement> thenStatements) {
		super();
		this.condition=condition;
		this.thenStatements=thenStatements;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IfBlock))
			return false;
		IfBlock ifBlock=(IfBlock) obj;
		return condition.equals(ifBlock.condition) &&
				thenStatements.equals(ifBlock.thenStatements);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(condition, thenStatements);
	}

	public boolean isExpressionBoolean(IdentifiersTypeMatcher typeMatcher) { 
		return condition.getType(typeMatcher).isBool();
	}

	@Override
	public String toString() {
		String str = "if(" + condition.toString() + ") \n {";
		for(Statement s: thenStatements)
			str+=s.toString() + "\n";
		str+= "} \n";

		return str;
	}

	public Expression getCondition() {
		return condition;
	}
}
