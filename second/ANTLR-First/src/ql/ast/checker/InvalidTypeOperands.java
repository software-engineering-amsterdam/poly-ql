package ql.ast.checker;

import java.util.LinkedList;
import java.util.List;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Statement;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class InvalidTypeOperands extends ASTVisitor {

	private List<Expression> operandsList;
	private IdentifiersTypeMatcher typeMatcher;

	public String check(Form root) {
		this.operandsList = new LinkedList<>();
		this.typeMatcher = new IdentifiersTypeMatcher();

		typeMatcher.search(root);
		root.accept(this);

		if(operandsList.size()!=0) {
			String message= "ERROR: The following expressions contain operands of invalid" +
					" type to operators: \n";
			for(Expression e: operandsList)
				message+=e.toString()+"\n";
			return message;
		}
		return null;
	}

	@Override
	public void visit(Expression leftHandOperand, Expression rightHandOperand)  {
		if(! leftHandOperand.areOperandsTypeValid(typeMatcher))
			recordError(leftHandOperand);		
		leftHandOperand.accept(this);
		if(! rightHandOperand.areOperandsTypeValid(typeMatcher))
			recordError(rightHandOperand);	
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Expression operand) {
		if(! operand.areOperandsTypeValid(typeMatcher))
			recordError(operand);	
		operand.accept(this);
	}

	@Override
	public void visit(Expression condition, List<Statement> thenStatements) {
		if(! condition.areOperandsTypeValid(typeMatcher))
			recordError(condition);		
		condition.accept(this);

		for(Statement s : thenStatements)
			s.accept(this);
	}

	@Override
	public void visit(Expression condition, List<Statement> thenStatements,
			List<Statement> elseStatements) {
		if(! condition.areOperandsTypeValid(typeMatcher))
			recordError(condition);
		condition.accept(this);

		for(Statement s : thenStatements)
			s.accept(this);
		for(Statement s : elseStatements)
			s.accept(this);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		if(! expr.areOperandsTypeValid(typeMatcher))
			recordError(expr);
	}

	private boolean recordError(Expression exp) {
		return operandsList.add(exp);
	}
}
