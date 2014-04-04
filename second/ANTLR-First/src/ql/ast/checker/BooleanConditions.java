package ql.ast.checker;

import java.util.LinkedList;
import java.util.List;

import ql.ast.node.Expression;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Statement;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class BooleanConditions extends ASTVisitor{

	private List<String> badConditions;
	private IdentifiersTypeMatcher typeMatcher;

	public String check(Form root) {
		badConditions=new LinkedList<>();
		typeMatcher=new IdentifiersTypeMatcher();

		typeMatcher.search(root);
		root.accept(this);

		if(badConditions.size()!=0) {
			String message= "ERROR: The following conditions contained in 'if' structures" +
					" should be of type boolean but are not: \n";
			for(String q: badConditions)
				message+=q.toString()+"\n";
			return message;
		}
		return null;
	}

	@Override
	public void visit(Expression condition, List<Statement> thenStatements) {
		if (! condition.isBoolean(typeMatcher))
			badConditions.add(condition.toString());

		for(Statement s : thenStatements)
			s.accept(this);
	}

	@Override
	public void visit(Expression condition, List<Statement> thenStatements, 
			List<Statement> elseStatements) {
		visit(condition,thenStatements);
		for(Statement s : elseStatements)
			s.accept(this);
	}
}
