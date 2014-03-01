package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.Expr;
import expr.syntacticExpr.IfBlock;

public class BooleanConditionsChecker extends ASTVisitor {
	
	private List<String> badConditions;	
	
	public BooleanConditionsChecker() {
		this.badConditions=new LinkedList<>();
	}
	
	public List<String> check(Expr root) {
		 root.accept(this);
		 return this.badConditions;
	}
	
	@Override
	public void visit(IfBlock ifBlock) {
		if (! ifBlock.isExpressionBoolean())
			this.badConditions.add(ifBlock.getCondition().toString());
	}
}
