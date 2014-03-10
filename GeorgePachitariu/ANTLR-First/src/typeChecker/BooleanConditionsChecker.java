package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.ASTNode;
import expr.syntactic.IfBlock;

public class BooleanConditionsChecker extends ASTVisitor {

	protected List<String> badConditions;
	private IdentifiersTypeMatcher typeMatcher;

	public BooleanConditionsChecker() {
		this.badConditions=new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public List<String> check(ASTNode root) {
		this.typeMatcher.match(root);
		root.accept(this);
		return this.badConditions;
	}

	@Override
	public void visit(IfBlock ifBlock) {
		if (! ifBlock.isExpressionBoolean(typeMatcher))
			this.badConditions.add(ifBlock.getCondition().toString());
	}
}
