package expr.syntactic;

import java.util.LinkedList;
import java.util.List;

import expr.ASTNode;
import expr.Expression;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


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
		return this.condition.equals(ifBlock.condition) &&
				this.thenStatements.equals(ifBlock.thenStatements);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this,this.condition, this.thenStatements);
	}

	public boolean isExpressionBoolean(IdentifiersTypeMatcher typeMatcher) { 
		return this.condition.getType(typeMatcher).isBoolean();
	}

	@Override
	public String toString() {
		String str = "if(" + this.condition.toString() + ") \n {";
		for(Statement s: thenStatements)
			str+=s.toString() + "\n";
		str+= "} \n";

		return str;
	}

	public Expression getCondition() {
		return this.condition;
	}

	@Override
	public ASTNode ReplaceQuestionValue(Question q) {
		List<Statement> list=new LinkedList<>();
		for(Statement s : this.thenStatements)
			list.add((Statement)s.ReplaceQuestionValue(q));
		return new IfBlock(this.condition,list);
	}
}
