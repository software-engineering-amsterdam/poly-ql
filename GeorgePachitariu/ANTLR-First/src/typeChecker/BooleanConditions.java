package typeChecker;

import java.util.LinkedList;
import java.util.List;

import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


import expr.ASTNode;
import expr.Expression;
import expr.syntactic.IfBlock;
import expr.syntactic.IfElseBlock;
import expr.syntactic.Statement;

public class BooleanConditions extends ASTVisitor{

	protected List<String> badConditions;
	protected IdentifiersTypeMatcher typeMatcher;

	public BooleanConditions() {
		this.badConditions=new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public List<String> check(ASTNode root) {
		this.typeMatcher.search(root);
		root.accept(this);
		return this.badConditions;
	}
	
	@Override
	public void visit(IfBlock ifBlock, Expression condition, List<Statement> thenStatements) {
		if (! ifBlock.isExpressionBoolean(typeMatcher))
			this.badConditions.add(ifBlock.getCondition().toString());
		
		for(Statement s : thenStatements)
			s.accept(this);
	}

	@Override
	public void visit(IfElseBlock ifElseBlock, Expression condition, 
				List<Statement> thenStatements, List<Statement> elseStatements) {
		if (! ifElseBlock.isExpressionBoolean(typeMatcher))
			this.badConditions.add(ifElseBlock.getCondition().toString());
		
		for(Statement s : thenStatements)
			s.accept(this);
		for(Statement s : elseStatements)
			s.accept(this);
	}
}
