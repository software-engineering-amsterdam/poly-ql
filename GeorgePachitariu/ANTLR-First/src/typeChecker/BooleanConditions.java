package typeChecker;

import java.util.LinkedList;
import java.util.List;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.syntactic.IfBlock;
import nodeAST.syntactic.IfElseBlock;
import nodeAST.syntactic.Statement;


import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;



public class BooleanConditions extends ASTVisitor{

	protected List<String> badConditions;
	protected IdentifiersTypeMatcher typeMatcher;

	public BooleanConditions() {
		this.badConditions=new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public void check(ASTNode root) throws Exception {
		this.typeMatcher.search(root);
		root.accept(this);
		
		if(badConditions.size()!=0) {
			String message= "ERROR: The following conditions contained in 'if' structures" +
					" should be of type boolean but are not: \n";
			for(String q: badConditions)
				message+=q.toString()+"\n";
			throw new Exception(message);
		}
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
